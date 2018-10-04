package pabloaraya.org.moviesparty.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import pabloaraya.org.moviesparty.R;
import pabloaraya.org.view.contract.MovieContract;
import pabloaraya.org.view.modelview.MovieModelView;
import pabloaraya.org.view.presenter.MoviePresenter;

public class MainActivity extends AppCompatActivity implements MovieContract.View {

    @Inject
    MoviePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter.attachView(this);
        presenter.loadMovies();
    }

    @Override
    public void setMovieItems(List<MovieModelView> movieItems) {

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


