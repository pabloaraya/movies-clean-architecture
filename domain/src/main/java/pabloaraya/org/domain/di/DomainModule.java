package pabloaraya.org.domain.di;

import dagger.Module;
import pabloaraya.org.data.di.DataModule;

@Module(includes = DataModule.class)
public class DomainModule {
}
