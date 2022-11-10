package com.halleluhya.halleluhya.services.halleimpl;

import com.halleluhya.halleluhya.dto.HalleluhyaDto;
import com.halleluhya.halleluhya.exceptions.HalleluhyaNotFoundException;
import com.halleluhya.halleluhya.models.Halleluhya;
import com.halleluhya.halleluhya.repository.HalleluhyaRepo;
import com.halleluhya.halleluhya.services.HalleluhyaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<HalleluhyaDto> getAllHalleluhya() {
//        Halleluhya halleluhya3 = HalleluhyaRepo.findById(333333).orElseThrow(() -> new HalleluhyaNotFoundException("Halleluhya not found by id"));
        List<Halleluhya> halleluhya = halleluhyaRepo.findAll();
        return halleluhya.stream().map(h ->maptoDto(h)).collect(Collectors.toList());
    }

    @Override
    public HalleluhyaDto getHalleluhyaid(int id) {
        Halleluhya halleluhya = halleluhyaRepo.findById(id).orElseThrow(() -> new HalleluhyaNotFoundException("Halleluhya not found by id"));
        return maptoDto(halleluhya);
    }

    public HalleluhyaDto maptoDto(Halleluhya halleluhya){
       HalleluhyaDto halleluhyaDto = new HalleluhyaDto();
       halleluhyaDto.setId(halleluhya.getId());
       halleluhyaDto.setName(halleluhya.getName());
       halleluhyaDto.setOccupation(halleluhya.getOccupation());
       return halleluhyaDto;
    }

    public Halleluhya maptoEntity(HalleluhyaDto halleluhyaDto){
        Halleluhya halleluhya = new Halleluhya();
        halleluhya.setName(halleluhyaDto.getName());
        halleluhya.setOccupation(halleluhyaDto.getOccupation());
        return halleluhya;
    }
    @Override
    public HalleluhyaDto updatehalleluhya(HalleluhyaDto halleluhyaDto, int id) {
        Halleluhya halleluhya = halleluhyaRepo.findById(id).orElseThrow(() -> new HalleluhyaNotFoundException("update not successful"));
        halleluhya.setName(halleluhyaDto.getName());
        halleluhya.setOccupation(halleluhyaDto.getOccupation());

        Halleluhya updatehalleluhya = halleluhyaRepo.save(halleluhya);

        return maptoDto(updatehalleluhya);
    }

    @Override
    public void deletehalleid(int id) {
       Halleluhya halleluhya = halleluhyaRepo.findById(id).orElseThrow(() -> new HalleluhyaNotFoundException("halle could nor delete"));
       halleluhyaRepo.delete(halleluhya);
    }


}
