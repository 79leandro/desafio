package br.com.leandro.teste.api.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.leandro.teste.api.services.movies.MovieAddService;
import br.com.leandro.teste.api.services.movies.MovieDeleteService;
import br.com.leandro.teste.api.services.movies.MovieGetService;
import br.com.leandro.teste.api.services.movies.MovieListService;
import br.com.leandro.teste.api.services.movies.dto.MovieDTO;
import br.com.leandro.teste.api.services.movies.dto.MoviesDTO;
import br.com.leandro.teste.api.services.movies.dto.NewMovieDTO;

@RestController
@RequestMapping("/movies")
public class MoviesRestController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    MovieListService movieListService;
    @Autowired
    MovieGetService movieGetService;
    @Autowired
    MovieAddService movieAddService;
    @Autowired
    MovieDeleteService movieDeleteService;

    @GetMapping
    public MoviesDTO list() {
        try {
            return movieListService.list();
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public MovieDTO get(
            @PathVariable Long id) {
        try {
            return movieGetService.find(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    public void add(
            @RequestBody NewMovieDTO dto) {
        try {
            movieAddService.add(dto);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage()); // 409
        }
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {
        try {
            movieDeleteService.delete(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, e.getMessage()); // 405
        }
    }
}