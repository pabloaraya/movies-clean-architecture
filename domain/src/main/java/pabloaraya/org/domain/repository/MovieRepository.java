package pabloaraya.org.domain.repository;

import io.reactivex.Observable;
import java.util.List;
import pabloaraya.org.domain.model.MovieModel;

public interface MovieRepository {

    Observable<List<MovieModel>> getMovies(String letter);

    Observable<List<MovieModel>> getMoviesByName(String name);
}
