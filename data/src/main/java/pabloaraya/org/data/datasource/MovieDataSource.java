package pabloaraya.org.data.datasource;

import java.util.List;

import io.reactivex.Observable;
import pabloaraya.org.data.entity.MovieEntity;

public interface MovieDataSource {

    Observable<List<MovieEntity>> getMovies();

    Observable<List<MovieEntity>> getMoviesByName(String name);
}
