package com.halleluhya.halleluhya.services.halleimpl;

import com.halleluhya.halleluhya.dto.HalleluhyaDto;
import com.halleluhya.halleluhya.models.Halleluhya;
import com.halleluhya.halleluhya.repository.HalleluhyaRepo;
import com.halleluhya.halleluhya.services.HalleluhyaService;
import org.springframework.stereotype.Service;

@Service
public class HalleluhyaImpl implements HalleluhyaService {
    private HalleluhyaRepo halleluhyaRepo;

    public HalleluhyaImpl(HalleluhyaRepo halleluhyaRepo) {
        this.halleluhyaRepo = halleluhyaRepo;
    }

    @Override
    public HalleluhyaDto createHalleluhya(HalleluhyaDto halleluhyaDto) {
        Halleluhya halleluhya = new Halleluhya();
        halleluhya.setName(halleluhyaDto.getName());
        halleluhya.setOccupation(halleluhyaDto.getOccupation());

        Halleluhya newhalle = halleluhyaRepo.save(halleluhya);

        HalleluhyaDto halleresponse = new HalleluhyaDto();
        halleresponse.setId(newhalle.getId());
        halleresponse.setName(newhalle.getName());
        halleresponse.setOccupation(newhalle.getOccupation());
        return halleresponse;

    }
}
