package pabloaraya.org.data.retrofit;

import io.reactivex.Observable;
import pabloaraya.org.data.entity.ResponseEntity;

public interface MovieRestApi {

  Observable<ResponseEntity> getMovies();
}
