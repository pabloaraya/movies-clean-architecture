package pabloaraya.org.data.datasource;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import pabloaraya.org.data.entity.MovieEntity;
import pabloaraya.org.data.entity.ResponseEntity;
import pabloaraya.org.data.retrofit.MovieRestApi;

public class MovieApiDataSource implements MovieDataSource {

  private MovieRestApi movieRestApi;

  @Inject
  public MovieApiDataSource(MovieRestApi movieRestApi) {
    this.movieRestApi = movieRestApi;
  }

  @Override
  public Observable<List<MovieEntity>> getMovies(String letter) {
    return movieRestApi.getMovies(letter).map(new Function<ResponseEntity, List<MovieEntity>>() {
      @Override public List<MovieEntity> apply(ResponseEntity responseEntity) {
        return responseEntity.movieEntities;
      }
    });
  }

  @Override
  public Observable<List<MovieEntity>> getMoviesByName(String name) {
    return movieRestApi.getMoviesByName(name).map(new Function<ResponseEntity, List<MovieEntity>>() {
      @Override
      public List<MovieEntity> apply(ResponseEntity responseEntity) {
        return responseEntity.movieEntities;
      }
    });
  }
}
