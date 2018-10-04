package pabloaraya.org.moviesparty;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import pabloaraya.org.moviesparty.di.DaggerApplicationComponent;

public class MovieApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().create(this);
    }
}
