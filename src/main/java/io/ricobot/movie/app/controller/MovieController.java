package io.ricobot.movie.app.controller;

import io.ricobot.movie.app.model.Cinema;
import io.ricobot.movie.app.model.Comment;
import io.ricobot.movie.app.model.Movie;
import io.ricobot.movie.app.repository.CommentRepository;
import io.ricobot.movie.app.repository.MovieRepository;
import io.ricobot.movie.core.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController extends Controller<Movie, Long> {

    @Autowired
    public void setRepository(MovieRepository repository) {
        this.repository = repository;
    }

    private CommentRepository commentRepository;

    @Autowired
    public void setCommentRepository(CommentRepository repository){
        this.commentRepository = repository;
    }

    @GetMapping("/cinema/{id}")
    public List<Movie> findAll(@PathVariable Long id) {
        return ((MovieRepository) repository).findAllByCinemasEquals(new Cinema(id));
    }

    @PostMapping("/comment/{id}")
    public Movie update(@RequestBody Comment comment, @PathVariable Long id){
        comment.setMovie(new Movie(id));
        comment.setCreatedAt(new Date());
        commentRepository.save(comment);
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}