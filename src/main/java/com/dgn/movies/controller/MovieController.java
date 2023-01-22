package com.dgn.movies.controller;

import com.dgn.movies.domain.Movie;
import com.dgn.movies.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
       List<Movie> movies =  movieService.getAllMovies();
       return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") ObjectId id){
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/movie")
    public ResponseEntity<Movie> getMovieByName(@RequestParam("name") String movieName){
        Movie movie = movieService.getMovieByName(movieName);
        return ResponseEntity.ok(movie);
    }
}
