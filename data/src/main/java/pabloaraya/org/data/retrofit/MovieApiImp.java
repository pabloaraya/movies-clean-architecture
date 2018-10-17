package pabloaraya.org.data.retrofit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import pabloaraya.org.data.entity.ResponseEntity;
import pabloaraya.org.data.net.OMDBService;

public class MovieApiImp extends RetrofitApiClient<OMDBService> implements MovieRestApi {

  private Scheduler scheduler;

  public MovieApiImp(Scheduler scheduler) {
    this.scheduler = scheduler;
  }

  @Override
  public Observable<ResponseEntity> getMovies() {
    return apiService.getMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(scheduler);
  }

  @Override
  public Observable<ResponseEntity> getMoviesByName(String name) {
    return apiService.getMoviesByName(name)
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
