package pabloaraya.org.moviesparty.activity;

import android.app.SearchManager;
import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.List;
import javax.inject.Inject;
import pabloaraya.org.moviesparty.MovieApplication;
import pabloaraya.org.moviesparty.R;
import pabloaraya.org.moviesparty.adapter.MovieAdapter;
import pabloaraya.org.moviesparty.common.BaseActivity;
import pabloaraya.org.moviesparty.di.DaggerMovieComponent;
import pabloaraya.org.moviesparty.di.MovieModule;
import pabloaraya.org.view.contract.MovieContract;
import pabloaraya.org.view.modelview.MovieModelView;
import pabloaraya.org.view.presenter.MoviePresenter;

public class MainActivity extends BaseActivity implements MovieContract.View {

  private RecyclerView.Adapter mAdapter;
  private RecyclerView.LayoutManager mLayoutManager;

  private RecyclerView mRecyclerView;
  private LottieAnimationView mProgressBar;

  @Inject MoviePresenter presenter;

  @Override protected void onPrepareActivity() {
    mProgressBar = findViewById(R.id.loading);
    mRecyclerView = findViewById(R.id.my_recycler_view);
    mLayoutManager = new GridLayoutManager(this, 2);
    mRecyclerView.setLayoutManager(mLayoutManager);
    mRecyclerView.setHasFixedSize(true);
  }

  @Override protected void onPreparePresenter() {
    presenter.attachView(this);
    presenter.loadMovies();
  }

  @Override
  public void setMovieItems(List<MovieModelView> movieItems) {
    mAdapter = new MovieAdapter(movieItems);
    mRecyclerView.setAdapter(mAdapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_main, menu);

    SearchManager searchManager =
        (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    SearchView searchView =
        (SearchView) menu.findItem(R.id.search).getActionView();
    searchView.setSearchableInfo(
        searchManager.getSearchableInfo(getComponentName()));

    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override public boolean onQueryTextSubmit(String query) {
        if (!query.isEmpty()) {
          presenter.loadMoviesByName(query);
        }
        return false;
      }

      @Override public boolean onQueryTextChange(String newText) {
        return false;
      }
    });

    return true;
  }

  @Override
  public void showLoading() {
    mProgressBar.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideLoading() {
    mProgressBar.setVisibility(View.GONE);
  }

  @Override
  public void showConnectionError() {
    Toast.makeText(this, "We have an error", Toast.LENGTH_SHORT).show();
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_main;
  }

  @Override protected void onInject() {
    DaggerMovieComponent.builder()
            .applicationComponent(MovieApplication.getApplicationComponent())
            .movieModule(new MovieModule())
            .build()
            .inject(this);
  }
}


