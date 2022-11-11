package com.halleluhya.halleluhya.services;

import com.halleluhya.halleluhya.dto.HalleluhyaDto;
import com.halleluhya.halleluhya.dto.Halleluhyaresponse;

import java.util.List;

public interface HalleluhyaService {
    HalleluhyaDto createHalleluhya(HalleluhyaDto halleluhyaDto);
//    List<HalleluhyaDto> getAllHalleluhya(int pageno, int pagesize);
    Halleluhyaresponse getAllHalleluhya(int pageno, int pagesize);
    HalleluhyaDto getHalleluhyaid(int id);
    HalleluhyaDto updatehalleluhya(HalleluhyaDto halleluhyaDto, int id);
    void deletehalleid(int id);
}
