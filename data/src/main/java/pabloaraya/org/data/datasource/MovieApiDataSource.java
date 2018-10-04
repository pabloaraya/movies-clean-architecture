package pabloaraya.org.data.datasource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import pabloaraya.org.data.entity.MovieEntity;
import pabloaraya.org.data.retrofit.MovieRestApi;

public class MovieApiDataSource implements MovieDataSource {

    @Inject MovieRestApi movieRestApi;

    @Override
    public Observable<List<MovieEntity>> getMovies() {
        return movieRestApi.getMovies();
    }
}
