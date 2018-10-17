package pabloaraya.org.view.presenter;

import javax.inject.Inject;

import pabloaraya.org.domain.usecase.GetMoviesByNameUseCase;
import pabloaraya.org.domain.usecase.GetMoviesUseCase;
import pabloaraya.org.view.contract.MovieContract;
import pabloaraya.org.view.mapper.MovieModelViewToMovieModelMapper;
import pabloaraya.org.view.observer.MovieByNameListObserver;
import pabloaraya.org.view.observer.MovieListObserver;

public class MoviePresenter extends BasePresenter<MovieContract.View>
        implements MovieContract.Presenter {

    private GetMoviesUseCase getMoviesUseCase;
    private GetMoviesByNameUseCase getMoviesByNameUseCase;
    private MovieModelViewToMovieModelMapper movieModelViewToMovieModelMapper;

    @Inject
    public MoviePresenter(GetMoviesUseCase getMoviesUseCase, GetMoviesByNameUseCase getMoviesByNameUseCase,
                          MovieModelViewToMovieModelMapper movieModelViewToMovieModelMapper) {
        this.getMoviesUseCase = getMoviesUseCase;
        this.getMoviesByNameUseCase = getMoviesByNameUseCase;
        this.movieModelViewToMovieModelMapper = movieModelViewToMovieModelMapper;
    }

    @Override
    public void loadMovies() {
        MovieListObserver movieListObserver = new MovieListObserver(movieModelViewToMovieModelMapper);
        movieListObserver.attachView(getView());
        getMoviesUseCase.execute(movieListObserver);
    }

    @Override
    public void loadMoviesByName(String name) {
        MovieByNameListObserver movieByNameListObserver = new MovieByNameListObserver(movieModelViewToMovieModelMapper);
        movieByNameListObserver.attachView(getView());
        getMoviesByNameUseCase.execute(movieByNameListObserver, name);

    }
}
