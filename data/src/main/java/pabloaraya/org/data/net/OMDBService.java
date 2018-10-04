package pabloaraya.org.data.net;

import java.util.List;

import io.reactivex.Observable;
import pabloaraya.org.data.entity.MovieEntity;
import retrofit2.http.GET;

public interface OMDBService {

    @GET("i=tt3896198&apikey=6f09952c")
    Observable<List<MovieEntity>> getMovies();
}
