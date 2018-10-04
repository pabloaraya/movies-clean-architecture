package pabloaraya.org.moviesparty.di;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import pabloaraya.org.view.di.PresentationModule;
import pabloaraya.org.view.presenter.MoviePresenter;

@Module(includes = PresentationModule.class)
public class ApplicationModule {

    @Provides
    public Scheduler provideAndroidProvide() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    public MoviePresenter provideMoviePresenter() {
        return new MoviePresenter();
    }
}
