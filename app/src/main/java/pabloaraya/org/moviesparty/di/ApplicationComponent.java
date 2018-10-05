package pabloaraya.org.moviesparty.di;

import android.app.Application;
import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import pabloaraya.org.moviesparty.MovieApplication;

@Singleton @Component(modules = { ApplicationModule.class }) public interface ApplicationComponent {

    Application getApplication();

    void inject(MovieApplication movieApplication);
}
