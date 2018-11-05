package io.ricobot.movie.app.controller;

import io.ricobot.movie.MovieApplication;
import io.ricobot.movie.app.model.Genre;
import io.ricobot.movie.app.model.Language;
import io.ricobot.movie.app.model.Movie;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MovieApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MovieControllerTest extends ControllerTest<Movie> {

    @Before
    public void beforeTest(){
        setEndpoint("/movies");
    }

    protected Movie create() {
        Movie movie = new Movie();
        movie.setName(faker.book().title());
        movie.setLanguage(new Language(1L));
        movie.setScore(faker.number().randomDouble(1, 1, 5));
        movie.setRated(faker.number().numberBetween(12, 21));
        movie.setDirector(faker.name().name());
        movie.setSynopsis(faker.lorem().paragraph());
        movie.setReleaseDate(new Date());
        movie.setThumb(faker.avatar().image());
        movie.setActors(faker.name().name());
        movie.setGenre(new Genre(1L));
        return movie;
    }
}
