package pabloaraya.org.moviesparty.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import pabloaraya.org.moviesparty.activity.MainActivity;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = ApplicationModule.class)
    public abstract MainActivity contributeMainActivity();
}
