package br.com.leandro.teste.api.services.movies;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandro.teste.api.models.Movie;
import br.com.leandro.teste.api.repository.MovieRepository;
import br.com.leandro.teste.api.services.movies.dto.MovieDTO;
import br.com.leandro.teste.api.services.movies.dto.MoviesDTO;

@Service
public class MovieListService {

    @Autowired MovieRepository movieRepository;

    public MoviesDTO list() {

        Iterable<Movie> movies = movieRepository.findAll();
        List<MovieDTO> moviesDTO = StreamSupport
                .stream(movies.spliterator(), false)
                .map(toDTO())
                .collect(Collectors.toList());

        return new MoviesDTO(moviesDTO);
    }

    private Function<Movie, MovieDTO> toDTO()
    {
        return v -> createMovieDTO(v);
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
