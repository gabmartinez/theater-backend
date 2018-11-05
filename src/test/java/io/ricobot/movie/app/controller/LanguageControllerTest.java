package io.ricobot.movie.app.controller;

import io.ricobot.movie.MovieApplication;
import io.ricobot.movie.app.model.Language;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MovieApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LanguageControllerTest extends ControllerTest<Language> {

    @Before
    public void beforeTest(){
        setEndpoint("/languages");
    }

    @Override
    protected Language create() {
        Language language = new Language();
        language.setName("Cinema Test");
        return language;
    }
}
