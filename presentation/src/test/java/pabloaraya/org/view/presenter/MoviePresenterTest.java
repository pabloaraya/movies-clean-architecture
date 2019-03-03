package pabloaraya.org.view.presenter;

import io.reactivex.observers.DisposableObserver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pabloaraya.org.domain.usecase.GetMoviesByNameUseCase;
import pabloaraya.org.domain.usecase.GetMoviesUseCase;
import pabloaraya.org.view.contract.MovieContract;
import pabloaraya.org.view.mapper.MovieModelViewToMovieModelMapper;
import pabloaraya.org.view.observer.MovieByNameListObserver;
import pabloaraya.org.view.observer.MovieListObserver;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class MoviePresenterTest {

  @Mock private GetMoviesUseCase getMoviesUseCase;
  @Mock private GetMoviesByNameUseCase getMoviesByNameUseCase;
  @Mock private MovieModelViewToMovieModelMapper movieModelViewToMovieModelMapper;
  @Mock private MovieListObserver movieListObserver;
  @Mock private MovieByNameListObserver movieByNameListObserver;
  @Mock private MovieContract.View view;

  @InjectMocks private MoviePresenter moviePresenter;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    moviePresenter.attachView(view);
  }

  @Test public void shouldExecuteLoadMoviesCorrectly() {
    moviePresenter.attachView(view);
    moviePresenter.loadMovies();
    verify(getMoviesUseCase, times(1)).execute(any(DisposableObserver.class));
    verifyNoMoreInteractions(movieListObserver);
  }

  @Test
  public void shouldExecuteLoadMoviesByNameCorrectly() {
    moviePresenter.attachView(view);
    moviePresenter.loadMoviesByName(anyString());
    verify(getMoviesByNameUseCase, times(1)).execute(any(DisposableObserver.class), anyString());
    verifyNoMoreInteractions(movieListObserver);
  }
}