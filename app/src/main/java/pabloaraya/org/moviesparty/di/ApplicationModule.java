package pabloaraya.org.moviesparty.di;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import pabloaraya.org.view.di.PresentationModule;

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
