package pabloaraya.org.view.mapper;

import javax.inject.Inject;
import pabloaraya.org.domain.model.MovieModel;
import pabloaraya.org.domain.repository.mapper.Mapper;
import pabloaraya.org.view.modelview.MovieModelView;

public class MovieModelViewToMovieModelMapper extends Mapper<MovieModelView, MovieModel> {

    @Inject
    public MovieModelViewToMovieModelMapper() {}

    @Override
    public MovieModel map(MovieModelView value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MovieModelView reverseMap(MovieModel value) {
        MovieModelView movieModelView = new MovieModelView();
        movieModelView.title = value.title;
        return movieModelView;
    }
}
