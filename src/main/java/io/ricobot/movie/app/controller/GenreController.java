package io.ricobot.movie.app.controller;

import io.ricobot.movie.app.model.Genre;
import io.ricobot.movie.app.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/genres")
public class GenreController extends Controller<Genre, Long> {

    @Autowired
    public void setRepository(GenreRepository repository) {
        this.repository = repository;
    }

}