package io.ricobot.movie.app.controller;

import io.ricobot.movie.MovieApplication;
import io.ricobot.movie.app.model.Role;
import io.ricobot.movie.app.model.User;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MovieApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserControllerTest extends ControllerTest<User> {

    @Before
    public void beforeTest(){
        setEndpoint("/users");
    }

    @Override
    protected User create() {
        User user = new User();
        user.setUsername(faker.name().username());
        user.setPassword(String.valueOf(faker.number().randomDigit()));
        user.setName(faker.name().name());
        user.setRole(new Role(1L));
        return user;
    }
}
