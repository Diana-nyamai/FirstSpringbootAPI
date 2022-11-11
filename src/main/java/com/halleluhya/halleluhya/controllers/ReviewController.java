package com.halleluhya.halleluhya.controllers;

import com.halleluhya.halleluhya.dto.ReviewDto;
import com.halleluhya.halleluhya.models.Review;
import com.halleluhya.halleluhya.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ReviewController {
    private ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/Halleluhya/{halleid}/createreview")
    public ResponseEntity<ReviewDto> createReview(@PathVariable(value = "halleid") int id,@RequestBody ReviewDto reviewDto){
       return new ResponseEntity<>(reviewService.createReview(id, reviewDto), HttpStatus.CREATED);
    }

    @GetMapping("/Halleluhya/{halleid}/reviews")
    public List<ReviewDto> gethalleluhyaById(@PathVariable(value = "halleid") int id){
        return reviewService.getReviewsByHalleluhyaId(id);
    }
}
