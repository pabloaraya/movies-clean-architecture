package pabloaraya.org.data.datasource.factory;

import pabloaraya.org.data.datasource.MovieApiDataSource;

public class MovieApiDataSourceFactory implements DataSourceFactory<MovieApiDataSource> {

    @Override
    public MovieApiDataSource createDataSource() {
        return new MovieApiDataSource();
    }
}
