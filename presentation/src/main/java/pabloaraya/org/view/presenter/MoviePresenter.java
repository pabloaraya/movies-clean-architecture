package pabloaraya.org.view.presenter;

import javax.inject.Inject;

import pabloaraya.org.domain.usecase.GetMoviesUseCase;
import pabloaraya.org.view.contract.MovieContract;
import pabloaraya.org.view.observer.MovieListObserver;

public class MoviePresenter extends BasePresenter<MovieContract.View>
        implements MovieContract.Presenter {

    private GetMoviesUseCase getMoviesUseCase;

    @Inject
    public MoviePresenter(GetMoviesUseCase getMoviesUseCase) {
        this.getMoviesUseCase = getMoviesUseCase;
    }

    @Override
    public void loadMovies() {
        MovieListObserver movieListObserver = new MovieListObserver();
        movieListObserver.attachView(getView());
        getMoviesUseCase.execute(movieListObserver);
    }


}
