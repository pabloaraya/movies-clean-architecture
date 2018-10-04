package pabloaraya.org.domain.usecase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import pabloaraya.org.domain.model.MovieModel;
import pabloaraya.org.domain.repository.MovieRepository;

public class GetMoviesUseCase extends UseCase<List<MovieModel>> {

    @Inject
    MovieRepository movieRepository;

    @Inject
    public GetMoviesUseCase(Scheduler scheduler) {
        super(scheduler);
    }

    @Override
    protected Observable<List<MovieModel>> buildUseCaseObservable() {
        return movieRepository.getMovies();
    }
}
