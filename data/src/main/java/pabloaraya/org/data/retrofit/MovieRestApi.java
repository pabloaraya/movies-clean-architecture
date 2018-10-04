package pabloaraya.org.data.retrofit;

import java.util.List;

import io.reactivex.Observable;
import pabloaraya.org.data.entity.MovieEntity;

public interface MovieRestApi {

    Observable<List<MovieEntity>> getMovies();
}
