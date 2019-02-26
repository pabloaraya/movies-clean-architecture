package pabloaraya.org.moviesparty.di;

import android.app.Application;
import dagger.Component;
import javax.inject.Singleton;
import pabloaraya.org.moviesparty.MovieApplication;

@Singleton @Component(modules = { ApplicationModule.class }) public interface ApplicationComponent {

    Application getApplication();

    void inject(MovieApplication movieApplication);
}
