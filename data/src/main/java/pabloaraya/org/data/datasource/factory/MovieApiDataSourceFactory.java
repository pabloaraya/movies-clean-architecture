package pabloaraya.org.data.datasource.factory;

import io.reactivex.Scheduler;
import javax.inject.Inject;
import pabloaraya.org.data.datasource.MovieApiDataSource;
import pabloaraya.org.data.retrofit.MovieApiImp;

public class MovieApiDataSourceFactory implements DataSourceFactory<MovieApiDataSource> {

  private Scheduler scheduler;

  @Inject
  public MovieApiDataSourceFactory(Scheduler scheduler) {
    this.scheduler = scheduler;
  }

  @Override
  public MovieApiDataSource createDataSource() {
    return new MovieApiDataSource(new MovieApiImp(scheduler));
  }
}
