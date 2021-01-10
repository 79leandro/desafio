package br.com.leandro.teste.api.services.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.leandro.teste.api.models.Movie;
import br.com.leandro.teste.api.repository.MovieRepository;
import br.com.leandro.teste.api.services.movies.dto.MovieDTO;

@Service
public class MovieGetService {

    @Autowired MovieRepository movieRepository;

    @Transactional
    public MovieDTO find(Long id) {

        Movie movie = movieRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("filme_nao_encontrado"));

        return createMovieDTO(movie);
    }

    private MovieDTO createMovieDTO(Movie v) {
        MovieDTO dto = new MovieDTO();
        dto.setId(v.getId());
        dto.setGenre(v.getGenre());
        dto.setName(v.getName());
        dto.setRate(v.getRate());
        dto.setReleaseYear(v.getReleaseYear());
        return dto;
    }
}