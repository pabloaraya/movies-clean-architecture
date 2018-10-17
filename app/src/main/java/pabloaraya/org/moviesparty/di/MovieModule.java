package pabloaraya.org.moviesparty.di;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import pabloaraya.org.data.datasource.factory.MovieApiDataSourceFactory;
import pabloaraya.org.domain.repository.MovieApiRepository;
import pabloaraya.org.domain.repository.MovieRepository;
import pabloaraya.org.domain.repository.mapper.MovieModelToMovieEntityMapper;
import pabloaraya.org.domain.usecase.GetMoviesByNameUseCase;
import pabloaraya.org.domain.usecase.GetMoviesUseCase;
import pabloaraya.org.view.mapper.MovieModelViewToMovieModelMapper;
import pabloaraya.org.view.observer.MovieListObserver;
import pabloaraya.org.view.presenter.MoviePresenter;

@Module
public class MovieModule {

    @Provides
    public MovieModelToMovieEntityMapper provideMovieModelToMovieEntityMapper() {
        return new MovieModelToMovieEntityMapper();
    }

    @Provides
    public MovieModelViewToMovieModelMapper provideMovieModelViewToMovieModelMapper() {
        return new MovieModelViewToMovieModelMapper();
    }

    @Provides
    public MovieApiDataSourceFactory provideMovieApiDataSourceFactory(Scheduler scheduler) {
        return new MovieApiDataSourceFactory(scheduler);
    }

    @Provides
    public MovieRepository provideMovieRepository(MovieApiDataSourceFactory movieApiDataSourceFactory,
                                                  MovieModelToMovieEntityMapper movieModelToMovieEntityMapper) {
        return new MovieApiRepository(movieApiDataSourceFactory.createDataSource(),
                movieModelToMovieEntityMapper);
    }

    @Provides
    public Scheduler provideAndroidProvide() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    public GetMoviesUseCase provideGetMoviesUseCase(MovieRepository movieRepository,
                                                    Scheduler scheduler) {
        return new GetMoviesUseCase(movieRepository, scheduler);
    }

    @Provides
    public GetMoviesByNameUseCase provideGetMoviesByName(MovieRepository movieRepository, Scheduler scheduler) {
        return new GetMoviesByNameUseCase(movieRepository, scheduler);
    }

    @Provides
    public MoviePresenter provideMoviePresenter(GetMoviesUseCase getMoviesUseCase, GetMoviesByNameUseCase getMoviesByNameUseCase,
                                                MovieModelViewToMovieModelMapper movieModelViewToMovieModelMapper) {
        return new MoviePresenter(getMoviesUseCase, getMoviesByNameUseCase, movieModelViewToMovieModelMapper);
    }

    @Provides
    public MovieListObserver provideMovieListObserver(
            MovieModelViewToMovieModelMapper movieModelViewToMovieModelMapper) {
        return new MovieListObserver(movieModelViewToMovieModelMapper);
    }
}
