package pabloaraya.org.view.contract;

import java.util.List;

import pabloaraya.org.view.modelview.MovieModelView;
import pabloaraya.org.view.presenter.BasePresenter;

public interface MovieContract {

    interface View extends BasePresenter.View {
        void setMovieItems(List<MovieModelView> movieItems);
    }

    interface Presenter {
        void loadMovies();
    }
}
