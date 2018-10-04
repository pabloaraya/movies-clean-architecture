package pabloaraya.org.moviesparty.fragment;

import android.os.Bundle;

import java.util.List;

import javax.inject.Inject;

import pabloaraya.org.moviesparty.R;
import pabloaraya.org.view.contract.MovieContract;
import pabloaraya.org.view.modelview.MovieModelView;
import pabloaraya.org.view.presenter.MoviePresenter;

public class MovieListFragment extends BaseFragment implements MovieContract.View {

    @Inject
    MoviePresenter presenter;

    public MovieListFragment() {
    }

    public static MovieListFragment getInstance() {
        MovieListFragment movieListFragment = new MovieListFragment();
        Bundle args = new Bundle();
        movieListFragment.setArguments(args);
        return movieListFragment;
    }

    @Override
    protected void onPreparePresenter() {
        attachPresenter(presenter, this);
        presenter.attachView(this);
        presenter.loadMovies();
    }

    @Override
    public void setMovieItems(List<MovieModelView> movieItems) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.movie_list_fragment;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showConnectionError() {

    }
}
