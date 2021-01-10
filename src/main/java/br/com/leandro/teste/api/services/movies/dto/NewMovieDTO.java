package br.com.leandro.teste.api.services.movies.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO utilizado para cadastro
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewMovieDTO implements Serializable {

    private String name;
    private String genre;
    private Integer releaseYear;
    private BigDecimal rate;
}
