package io.ricobot.movie.app.controller;

import io.ricobot.movie.app.model.User;
import io.ricobot.movie.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController extends Controller<User, Long> {

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

}