package pabloaraya.org.moviesparty.di;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import pabloaraya.org.domain.usecase.GetMoviesUseCase;
import pabloaraya.org.view.di.PresentationModule;
import pabloaraya.org.view.mapper.MovieModelViewToMovieModelMapper;
import pabloaraya.org.view.presenter.MoviePresenter;

@Module(includes = PresentationModule.class)
public class ApplicationModule {

  private Application mApplication;

  public ApplicationModule(Application application) {
    mApplication = application;
  }

  @Provides
  Application providesApplication() {
    return mApplication;
  }
}
