package pabloaraya.org.domain.usecase;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.util.List;
import java.util.Random;
import javax.inject.Inject;
import pabloaraya.org.domain.common.UseCase;
import pabloaraya.org.domain.model.MovieModel;
import pabloaraya.org.domain.repository.MovieRepository;

public class GetMoviesUseCase extends UseCase<List<MovieModel>> {

    private MovieRepository movieRepository;

    @Inject
    public GetMoviesUseCase(MovieRepository movieRepository, Scheduler scheduler) {
        super(scheduler);
        this.movieRepository = movieRepository;
    }

    @Override
    protected Observable<List<MovieModel>> buildUseCaseObservable() {
      String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

      Random random = new Random();
      String letter = String.valueOf(abc.charAt(random.nextInt(abc.length())));

      return movieRepository.getMovies(letter);
    }
}
