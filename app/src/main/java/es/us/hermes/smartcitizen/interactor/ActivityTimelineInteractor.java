package es.us.hermes.smartcitizen.interactor;

import com.google.android.gms.fitness.request.DataReadRequest;

import java.util.List;

import rx.Observable;
import es.us.hermes.smartcitizen.data.api.google.fit.ActivityDetails;

public interface ActivityTimelineInteractor extends Interactor {

    DataReadRequest.Builder buildFitDataReadRequest();
    Observable<List<ActivityDetails>> getGoogleFitQueryResponse(int timeRange);

}
