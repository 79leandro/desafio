package br.com.leandro.teste.api.services.movies.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

// DTO utilizado para retorno de pesquisas
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTO implements Serializable {

    private Long id;
    private String name;
    private String genre;
    private Integer releaseYear;
    private BigDecimal rate;
}
