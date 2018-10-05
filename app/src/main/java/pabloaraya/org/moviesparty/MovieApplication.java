package pabloaraya.org.moviesparty;

import android.app.Application;
import pabloaraya.org.moviesparty.di.ApplicationComponent;
import pabloaraya.org.moviesparty.di.ApplicationModule;
import pabloaraya.org.moviesparty.di.DaggerApplicationComponent;

public class MovieApplication extends Application {

    private static ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        applicationComponent =
            DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();

        applicationComponent.inject(this);
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
