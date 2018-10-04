package pabloaraya.org.moviesparty.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import pabloaraya.org.moviesparty.MovieApplication;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        ActivityModule.class
})
public interface ApplicationComponent extends AndroidInjector<MovieApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<MovieApplication> {
    }
}
