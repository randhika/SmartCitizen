package es.us.hermes.smartcitizen.di.components;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import dagger.Component;
import okhttp3.OkHttpClient;
import es.us.hermes.smartcitizen.data.api.hermes.HermesCitizenApi;
import es.us.hermes.smartcitizen.data.api.ztreamy.ZtreamyApi;
import es.us.hermes.smartcitizen.di.modules.ApplicationModule;
import es.us.hermes.smartcitizen.di.modules.InteractorsModule;
import es.us.hermes.smartcitizen.di.modules.NetworkModule;
import es.us.hermes.smartcitizen.di.modules.SyncServiceModule;
import es.us.hermes.smartcitizen.di.scopes.PerApp;
import es.us.hermes.smartcitizen.interactor.ActivityTimelineInteractor;
import es.us.hermes.smartcitizen.interactor.FitnessInteractor;
import es.us.hermes.smartcitizen.interactor.LocationDetailsInteractor;
import es.us.hermes.smartcitizen.interactor.LoginInteractor;
import es.us.hermes.smartcitizen.interactor.MainInteractor;
import es.us.hermes.smartcitizen.interactor.SyncServiceInteractor;
import es.us.hermes.smartcitizen.receiver.OnBootReceiver;
import es.us.hermes.smartcitizen.service.SyncService;
import es.us.hermes.smartcitizen.ui.activity.BaseActivity;
import es.us.hermes.smartcitizen.utils.RxNetwork;

@PerApp
@Component(
        modules = {
                ApplicationModule.class,
                NetworkModule.class,
                InteractorsModule.class,
                SyncServiceModule.class
        }
)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);
    void inject(SyncService syncService);
    void inject(OnBootReceiver onBootReceiver);

    Context getContext();
    SharedPreferences getSharedPreferences();

    RxNetwork getRxNetwork();
    OkHttpClient getOkHttpClient();
    Gson getGson();
    HermesCitizenApi getHermesCitizenApi();
    ZtreamyApi getZtreamyApi();
    SyncService getSyncService();

    LoginInteractor getLoginInteractor();
    MainInteractor getMainInteractor();
    FitnessInteractor getFitnessInteractor();
    ActivityTimelineInteractor getActivityTimelineInteractor();
    LocationDetailsInteractor getLocationDetailsInteractor();
    SyncServiceInteractor getSyncServiceInteractor();

}