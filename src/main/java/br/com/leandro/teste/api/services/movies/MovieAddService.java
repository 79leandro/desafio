package br.com.leandro.teste.api.services.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.leandro.teste.api.models.Movie;
import br.com.leandro.teste.api.repository.MovieRepository;
import br.com.leandro.teste.api.services.movies.dto.NewMovieDTO;

@Service
public class MovieAddService {

    @Autowired MovieRepository movieRepository;

    @Transactional
    public void add(NewMovieDTO dto) {

        if (movieRepository.existsByName(dto.getName()))
            throw new RuntimeException("filme_ja_existe");

        Movie movie = new Movie();
        movie.setName(dto.getName());
        movie.setGenre(dto.getGenre());
        movie.setRate(dto.getRate());
        movie.setReleaseYear(dto.getReleaseYear());
        movieRepository.save(movie);
    }

}