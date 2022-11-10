package com.halleluhya.halleluhya.repository;

import com.halleluhya.halleluhya.models.Halleluhya;
import org.springframework.data.jpa.repository.JpaRepository;

//  interfaces do not contain a body
public interface HalleluhyaRepo extends JpaRepository<Halleluhya, Integer> {

}
