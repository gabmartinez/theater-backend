package io.ricobot.movie.app.controller;

import io.ricobot.movie.MovieApplication;
import io.ricobot.movie.app.model.Comment;

import java.util.Date;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MovieApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CommentControllerTest extends ControllerTest<Comment> {

    @Before
    public void beforeTest(){
        setEndpoint("/comments");
        this.property = "details";
    }

    @Override
    protected Comment create() {
        Comment comment = new Comment();
        comment.setCreatedBy("User 1");
        comment.setCreatedAt(new Date());
        comment.setDetails("Comment from test user");
        return comment;
    }
}
