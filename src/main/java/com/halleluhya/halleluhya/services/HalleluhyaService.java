package com.halleluhya.halleluhya.services;

import com.halleluhya.halleluhya.dto.HalleluhyaDto;

import java.util.List;

public interface HalleluhyaService {
    HalleluhyaDto createHalleluhya(HalleluhyaDto halleluhyaDto);
    List<HalleluhyaDto> getAllHalleluhya();
}
