package pabloaraya.org.view.observer;

import java.util.List;
import javax.inject.Inject;
import pabloaraya.org.domain.common.UseCaseViewObserver;
import pabloaraya.org.domain.model.MovieModel;
import pabloaraya.org.view.contract.MovieContract;
import pabloaraya.org.view.mapper.MovieModelViewToMovieModelMapper;
import pabloaraya.org.view.modelview.MovieModelView;

public class MovieByNameListObserver extends UseCaseViewObserver<MovieContract.View, List<MovieModel>> {

    private MovieModelViewToMovieModelMapper movieModelViewToMovieModelMapper;

    @Inject
    public MovieByNameListObserver(MovieModelViewToMovieModelMapper movieModelViewToMovieModelMapper) {
        this.movieModelViewToMovieModelMapper = movieModelViewToMovieModelMapper;
    }

    @Override
    protected void onStart() {
        getView().showLoading();
    }

    @Override
    public void onComplete() {
        getView().hideLoading();
    }

    @Override
    public void onNext(List<MovieModel> movieModels) {
        List<MovieModelView> movieModelViews = movieModelViewToMovieModelMapper.reverseMap(movieModels);
        getView().setMovieItems(movieModelViews);
    }

    @Override
    public void onError(Throwable e) {
        getView().hideLoading();
        getView().showConnectionError();
    }
}
