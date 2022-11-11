package com.halleluhya.halleluhya.repository;

import com.halleluhya.halleluhya.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
    List<Review> findByHalleluhyaId(int halleluhyaId);
}
