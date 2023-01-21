package com.dgn.movies.service;

import com.dgn.movies.domain.Movie;
import com.dgn.movies.exception.MovieNotFoundException;
import com.dgn.movies.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(ObjectId id) {
        return movieRepository.findById(id).orElseThrow(()-> new MovieNotFoundException("Movie Not Found"));
    }

    public Movie getMovieByName(String movieName) {
        return movieRepository.findByTitle(movieName).orElseThrow(() -> new MovieNotFoundException("Movie Not Found"));
    }
}
