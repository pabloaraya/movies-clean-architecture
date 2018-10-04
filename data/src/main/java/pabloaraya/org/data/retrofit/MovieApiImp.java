package pabloaraya.org.data.retrofit;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import pabloaraya.org.data.entity.MovieEntity;
import pabloaraya.org.data.net.OMDBService;

public class MovieApiImp extends RetrofitApiClient<OMDBService> implements MovieRestApi {

    @Inject
    Scheduler scheduler;

    @Override
    public Observable<List<MovieEntity>> getMovies() {
        return apiService.getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(scheduler);
    }

    @Override
    protected Class<OMDBService> getApiService() {
        return OMDBService.class;
    }

    @Override
    protected String getBaseURL() {
        return "http://www.omdbapi.com/";
    }
}
