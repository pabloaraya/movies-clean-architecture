package pabloaraya.org.data.net;

import io.reactivex.Observable;
import pabloaraya.org.data.entity.ResponseEntity;
import retrofit2.http.GET;

public interface OMDBService {

  @GET("?s=saw&apikey=6f09952c")
  Observable<ResponseEntity> getMovies();
}
