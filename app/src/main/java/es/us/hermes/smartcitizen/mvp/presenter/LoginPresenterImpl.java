package es.us.hermes.smartcitizen.mvp.presenter;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;
import es.us.hermes.smartcitizen.data.api.hermes.entity.User;
import es.us.hermes.smartcitizen.interactor.LoginInteractor;
import es.us.hermes.smartcitizen.mvp.view.LoginView;
import es.us.hermes.smartcitizen.mvp.view.View;

public class LoginPresenterImpl implements LoginPresenter{

    private LoginView mLoginView;
    private final LoginInteractor mLoginInteractor;
    private Subscription mSubscription = Subscriptions.empty();

    @Inject
    public LoginPresenterImpl(LoginInteractor loginInteractor){
        this.mLoginInteractor = loginInteractor;
    }

    @Override
    public void setView(View v) {
        mLoginView = (LoginView) v;
    }

    @Override
    public void onPause() {
        if(!mSubscription.isUnsubscribed()){
            mSubscription.unsubscribe();
        }
    }

    @Override
    public void handleGoogleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess() && result.getSignInAccount() != null) {
            // Signed in successfully, register user in Smart Citizen backend.
            GoogleSignInAccount account = result.getSignInAccount();
            onGoogleSignInAccountReady(account);
        } else {
            // Signed out
            this.mLoginView.showGoogleSignInErrorMessage();
        }
    }

    private void onGoogleSignInAccountReady(GoogleSignInAccount account) {
        this.mLoginView.showProgressDialog();
        mSubscription = this.mLoginInteractor.loginOrRegisterUserInHermes(account)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onUserLogged,
                        throwable -> {
                            this.onLoginException(throwable);
                            this.mLoginView.hideProgressDialog();
                        },
                        () -> this.mLoginView.hideProgressDialog()
                );
    }

    @Override
    public void onUserLogged(User user) {
        this.mLoginInteractor.saveLoggedUserInPreferences(user);
        this.mLoginView.showLoginSuccessMessage();
        this.mLoginView.navigateToMainScreen();
        this.mLoginView.finishActivity();
    }

    @Override
    public void onLoginException(Throwable throwable) {
        this.mLoginView.doGoogleSignOut();
        this.mLoginView.doGoogleRevokeAccess();
        this.mLoginView.showErrorMessage(throwable);
    }

}