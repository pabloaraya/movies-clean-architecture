package pabloaraya.org.domain.repository;

import java.util.List;

import io.reactivex.Observable;
import pabloaraya.org.domain.model.MovieModel;

public interface MovieRepository {

    Observable<List<MovieModel>> getMovies();
}
