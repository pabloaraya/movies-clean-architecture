package pabloaraya.org.data.retrofit;

import io.reactivex.Observable;
import pabloaraya.org.data.entity.ResponseEntity;

public interface MovieRestApi {

  Observable<ResponseEntity> getMovies(String letter);

  Observable<ResponseEntity> getMoviesByName(String name);
}
