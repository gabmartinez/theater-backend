package io.ricobot.movie.app.controller;

import io.ricobot.movie.app.model.Language;
import io.ricobot.movie.app.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/languages")
public class LanguageController extends Controller<Language, Long> {

    @Autowired
    public void setRepository(LanguageRepository repository) {
        this.repository = repository;
    }

}