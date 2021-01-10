package br.com.leandro.teste.api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.leandro.teste.api.models.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    Optional<Movie> findById(Long id);
    public boolean existsByName(String name);
}