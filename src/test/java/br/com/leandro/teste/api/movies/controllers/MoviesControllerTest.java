package br.com.leandro.teste.api.movies.controllers;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.leandro.teste.api.controlers.MoviesRestController;
import br.com.leandro.teste.api.services.movies.MovieAddService;
import br.com.leandro.teste.api.services.movies.MovieDeleteService;
import br.com.leandro.teste.api.services.movies.MovieGetService;
import br.com.leandro.teste.api.services.movies.MovieListService;
import io.restassured.http.ContentType;

@WebMvcTest
public class MoviesControllerTest {
	
	@Autowired
	private MoviesRestController moviesRestController;

	@MockBean
    MovieListService movieListService;
	
    @MockBean
    MovieGetService movieGetService;
    
    @MockBean
    MovieAddService movieAddService;
    
    @MockBean
    MovieDeleteService movieDeleteService;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.moviesRestController);
	}
	
	@Test
	public void deveRetornarSucessoAoListarFilmes()
	{
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/movies")
		.then()
			.statusCode(org.springframework.http.HttpStatus.OK.value());
		
		
	}

	@Test
	public void deveRetornarSucessoAoBuscarFilmePorId()
	{
		
		given()
			.accept(ContentType.JSON)
		.when()
		.get("/movies/{id}",1L)
		.then()
		.statusCode(org.springframework.http.HttpStatus.OK.value());
		
		
	}
	
	@Test
	public void deveRetornarNaoEncontradoAoBuscarFilmeNaoExistente() {
		when(this.movieGetService.find(100L))
			.thenReturn(null);
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/{id}",100L)
		.then()
			.statusCode(org.springframework.http.HttpStatus.NOT_FOUND.value());
		
	}
}
