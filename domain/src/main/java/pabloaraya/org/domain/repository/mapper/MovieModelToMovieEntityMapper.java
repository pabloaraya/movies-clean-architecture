package pabloaraya.org.domain.repository.mapper;

import pabloaraya.org.data.entity.MovieEntity;
import pabloaraya.org.domain.model.MovieModel;

public class MovieModelToMovieEntityMapper extends Mapper<MovieModel, MovieEntity> {

    @Override
    public MovieEntity map(MovieModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MovieModel reverseMap(MovieEntity value) {
        MovieModel movieModel = new MovieModel();
        movieModel.title = value.title;
        return movieModel;
    }
}
