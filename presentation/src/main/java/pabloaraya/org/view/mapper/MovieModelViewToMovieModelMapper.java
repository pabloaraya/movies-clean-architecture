package pabloaraya.org.view.mapper;

import pabloaraya.org.domain.model.MovieModel;
import pabloaraya.org.domain.repository.mapper.Mapper;
import pabloaraya.org.view.modelview.MovieModelView;

public class MovieModelViewToMovieModelMapper extends Mapper<MovieModelView, MovieModel> {

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
