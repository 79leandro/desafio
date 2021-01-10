package br.com.leandro.teste.api.services.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.leandro.teste.api.models.Movie;
import br.com.leandro.teste.api.repository.MovieRepository;

@Service
public class MovieDeleteService {

    @Autowired MovieRepository movieRepository;

    @Transactional
    public void delete(Long id) {

        Movie movie = movieRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("filme_nao_encontrado"));

        movieRepository.delete(movie);
    }

}