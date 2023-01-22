package com.dgn.movies.controller;

import com.dgn.movies.domain.Review;
import com.dgn.movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/add")
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> review) {

        return new ResponseEntity<Review>(reviewService.createReview(review.get("reviewBody"), review.get("title")), HttpStatus.OK);
    }





}
