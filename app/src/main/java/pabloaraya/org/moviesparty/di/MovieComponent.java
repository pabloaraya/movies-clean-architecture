package pabloaraya.org.moviesparty.di;

import dagger.Component;
import pabloaraya.org.moviesparty.activity.MainActivity;

@ActivityScope @Component(modules = MovieModule.class, dependencies = ApplicationComponent.class)
public interface MovieComponent {

    void inject(MainActivity mainActivity);
}
