package io.ricobot.movie.app.controller;

import io.ricobot.movie.app.model.Comment;
import io.ricobot.movie.app.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentController extends Controller<Comment, Long> {

    @Autowired
    public void setRepository(CommentRepository repository) {
        this.repository = repository;
    }

}