package pabloaraya.org.view.presenter;

import java.util.List;

import javax.inject.Inject;

import pabloaraya.org.domain.model.MovieModel;
import pabloaraya.org.domain.usecase.GetMoviesUseCase;
import pabloaraya.org.domain.usecase.UseCaseObserver;
import pabloaraya.org.view.contract.MovieContract;
import pabloaraya.org.view.mapper.MovieModelViewToMovieModelMapper;
import pabloaraya.org.view.modelview.MovieModelView;

public class MoviePresenter extends BasePresenter<MovieContract.View> implements MovieContract.Presenter {

    private GetMoviesUseCase getMoviesUseCase;
    private MovieModelViewToMovieModelMapper movieModelViewToMovieModelMapper;

    @Inject
    public MoviePresenter(GetMoviesUseCase getMoviesUseCase, MovieModelViewToMovieModelMapper movieModelViewToMovieModelMapper) {
        this.getMoviesUseCase = getMoviesUseCase;
        this.movieModelViewToMovieModelMapper = movieModelViewToMovieModelMapper;
    }

    @Override
    public void loadMovies() {
        getMoviesUseCase.execute(new MovieListObserver());
    }

    private class MovieListObserver extends UseCaseObserver<List<MovieModel>> {

        @Override protected void onStart() {
            getView().showLoading();
        }

        @Override public void onComplete() {
            getView().hideLoading();
        }

        @Override public void onNext(List<MovieModel> movieModels) {
            List<MovieModelView> productViews = movieModelViewToMovieModelMapper.reverseMap(movieModels);
            getView().setMovieItems(productViews);
        }

        @Override public void onError(Throwable e) {
            getView().hideLoading();
            getView().showConnectionError();
        }
    }
}
