package pabloaraya.org.domain.usecase;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.util.List;
import javax.inject.Inject;
import pabloaraya.org.domain.common.UseCaseParam;
import pabloaraya.org.domain.model.MovieModel;
import pabloaraya.org.domain.repository.MovieRepository;

public class GetMoviesByNameUseCase extends UseCaseParam<String, List<MovieModel>> {

    private MovieRepository movieRepository;

    @Inject
    public GetMoviesByNameUseCase(MovieRepository movieRepository, Scheduler scheduler) {
        super(scheduler);
        this.movieRepository = movieRepository;
    }

    @Override
    protected Observable<List<MovieModel>> buildUseCaseObservable(String name) {
        return movieRepository.getMoviesByName(name);
    }
}
