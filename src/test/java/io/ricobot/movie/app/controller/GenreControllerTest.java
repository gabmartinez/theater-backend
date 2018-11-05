package io.ricobot.movie.app.controller;

import io.ricobot.movie.MovieApplication;
import io.ricobot.movie.app.model.Genre;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MovieApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class GenreControllerTest extends ControllerTest<Genre> {

    @Before
    public void beforeTest(){
        setEndpoint("/genres");
    }

    @Override
    protected Genre create() {
        Genre genre = new Genre();
        genre.setName("Cinema Test");
        return genre;
    }
}
