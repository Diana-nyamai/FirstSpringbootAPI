package com.halleluhya.halleluhya.services.halleimpl;

import com.halleluhya.halleluhya.dto.ReviewDto;
import com.halleluhya.halleluhya.exceptions.HalleluhyaNotFoundException;
import com.halleluhya.halleluhya.models.Halleluhya;
import com.halleluhya.halleluhya.models.Review;
import com.halleluhya.halleluhya.repository.HalleluhyaRepo;
import com.halleluhya.halleluhya.repository.ReviewRepo;
import com.halleluhya.halleluhya.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Reviewimpl implements ReviewService {
    private ReviewRepo reviewRepo;
    private HalleluhyaRepo halleluhyaRepo;
@Autowired
    public Reviewimpl(ReviewRepo reviewRepo, HalleluhyaRepo halleluhyaRepo) {
        this.reviewRepo = reviewRepo;
        this.halleluhyaRepo = halleluhyaRepo;
    }

    @Override
    public ReviewDto createReview(int halleluhyaid, ReviewDto reviewDto) {
        Review review = maptoEntity(reviewDto);
        Halleluhya halleluhya = halleluhyaRepo.findById(halleluhyaid).orElseThrow(() -> new  HalleluhyaNotFoundException("halleluhya with the id not found"));
        review.setHalleluhya(halleluhya);

        Review newreview = reviewRepo.save(review);
        return maptoDto(newreview);
    }

    @Override
    public List<ReviewDto> getReviewsByHalleluhyaId(int id){
    List<Review> reviews = reviewRepo.findByHalleluhyaId(id);
        return reviews.stream().map(review -> maptoDto(review)).collect(Collectors.toList());
    }
    public Review maptoEntity(ReviewDto reviewDto){
       Review review = new Review();
       review.setTitle(reviewDto.getTitle());
       review.setContent(reviewDto.getContent());
       review.setStars(reviewDto.getStars());
       return review;
    }
    public ReviewDto maptoDto(Review review){
    ReviewDto reviewDto = new ReviewDto();
    reviewDto.setId(review.getId());
    reviewDto.setTitle(review.getTitle());
    reviewDto.setContent(review.getContent());
    reviewDto.setStars(review.getStars());
    return reviewDto;
    }
}
