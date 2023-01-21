package com.dgn.movies.controller;

import com.dgn.movies.domain.Movie;
import com.dgn.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> allMovies(){
       List<Movie> movies =  movieService.getAllMovies();
       return ResponseEntity.ok(movies);
    }
}
