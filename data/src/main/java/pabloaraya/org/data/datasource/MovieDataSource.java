package pabloaraya.org.data.datasource;

import io.reactivex.Observable;
import java.util.List;
import pabloaraya.org.data.entity.MovieEntity;

public interface MovieDataSource {

    Observable<List<MovieEntity>> getMovies(String letter);

    Observable<List<MovieEntity>> getMoviesByName(String name);
}
