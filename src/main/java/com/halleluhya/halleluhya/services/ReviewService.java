package com.halleluhya.halleluhya.services;

import com.halleluhya.halleluhya.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
 ReviewDto createReview(int halleluhyaid, ReviewDto reviewDto);
 List<ReviewDto> getReviewsByHalleluhyaId(int id);
}
