package io.ricobot.movie.app.controller;

import io.ricobot.movie.MovieApplication;
import io.ricobot.movie.app.model.Cinema;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MovieApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CinemaControllerTest extends ControllerTest<Cinema> {

    @Before
    public void beforeTest(){
        setEndpoint("/cinemas");
    }

    @Override
    protected Cinema create() {
        Cinema cinema = new Cinema();
        cinema.setName("Cinema " + faker.address().cityName());
        return cinema;
    }
}
