package pabloaraya.org.data.net;

import io.reactivex.Observable;
import pabloaraya.org.data.entity.ResponseEntity;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OMDBService {

  @GET("?s=saw&apikey=6f09952c")
  Observable<ResponseEntity> getMovies();

  @GET("?apikey=6f09952c")
  Observable<ResponseEntity> getMoviesByName(@Query("s") String name);
}
