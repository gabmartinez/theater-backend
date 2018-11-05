package io.ricobot.movie.app.controller;

import io.ricobot.movie.core.exception.NotFoundException;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public abstract class Controller<T, ID> {

    protected JpaRepository<T, ID> repository;

    @GetMapping
    public List<T> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public T find(@PathVariable ID id) {
        return repository.findById( id ).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Object save(@RequestBody T obj) {
        try {
            return repository.save(obj);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public Object save(@RequestBody List<T> obj) {
        try {
            return repository.saveAll(obj);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        repository.findById( id ).orElseThrow(NotFoundException::new);
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public T update(@RequestBody T obj, @PathVariable ID id) {
        repository.findById(id).orElseThrow(NotFoundException::new);
        return repository.save(obj);
    }

    @GetMapping(value = "/list", params = { "page", "size" })
    public Iterable<T> list(@RequestParam("page") int page, @RequestParam("size") int size) {
        return repository.findAll(PageRequest.of(page, size));
    }
}
