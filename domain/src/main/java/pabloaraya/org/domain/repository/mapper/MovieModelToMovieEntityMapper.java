package pabloaraya.org.domain.repository.mapper;

import javax.inject.Inject;
import pabloaraya.org.data.entity.MovieEntity;
import pabloaraya.org.domain.model.MovieModel;

public class MovieModelToMovieEntityMapper extends Mapper<MovieModel, MovieEntity> {

  @Inject
  public MovieModelToMovieEntityMapper() {
  }

  @Override
  public MovieEntity map(MovieModel value) {
    throw new UnsupportedOperationException();
  }

  @Override
  public MovieModel reverseMap(MovieEntity value) {
    MovieModel movieModel = new MovieModel();
    movieModel.title = value.title;
    movieModel.poster = value.poster;
    return movieModel;
  }
}
