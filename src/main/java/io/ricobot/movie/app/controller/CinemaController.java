package io.ricobot.movie.app.controller;

import io.ricobot.movie.app.model.Cinema;
import io.ricobot.movie.app.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cinemas")
public class CinemaController extends Controller<Cinema, Long> {

    @Autowired
    public void setRepository(CinemaRepository repository) {
        this.repository = repository;
    }

}