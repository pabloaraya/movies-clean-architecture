package pabloaraya.org.domain.di;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import pabloaraya.org.data.di.DataModule;
import pabloaraya.org.domain.usecase.GetMoviesUseCase;

@Module(includes = DataModule.class)
public class DomainModule {


}
