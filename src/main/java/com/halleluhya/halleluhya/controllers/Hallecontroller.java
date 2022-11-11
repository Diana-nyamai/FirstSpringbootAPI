package com.halleluhya.halleluhya.controllers;

import com.halleluhya.halleluhya.dto.HalleluhyaDto;
import com.halleluhya.halleluhya.dto.Halleluhyaresponse;
import com.halleluhya.halleluhya.models.Halleluhya;
import com.halleluhya.halleluhya.services.HalleluhyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class Hallecontroller {
    private HalleluhyaService halleluhyaService;
    @Autowired
    public Hallecontroller(HalleluhyaService halleluhyaService) {
        this.halleluhyaService = halleluhyaService;
    }

    @GetMapping("Halleluhya")
//    ResponseEntity<List<Halleluhya>>
//    public ResponseEntity<List<HalleluhyaDto>> getHalleluhyas(
    public ResponseEntity<Halleluhyaresponse> getHalleluhyas(
            @RequestParam(value = "pageno", defaultValue = "0", required = false) int pageno,
            @RequestParam(value = "pagesize", defaultValue = "10", required = false) int pagesize
    ){
//        return new ResponseEntity<>( halleluhyaService.getAllHalleluhya(), HttpStatus.OK);
        return ResponseEntity.ok(halleluhyaService.getAllHalleluhya(pageno, pagesize));
//      List<Halleluhya> halleluhyas = new ArrayList<>();
//      halleluhyas.add(new Halleluhya(1,"ndinda", "software developer"));
//      halleluhyas.add(new Halleluhya(2,"diana", "web developer"));
//      halleluhyas.add(new Halleluhya(3,"fiona", "advocate"));
//      return ResponseEntity.ok(halleluhyas);
    }

    @GetMapping("/Halleluhya/{id}")
// Halleluhya
    public ResponseEntity<HalleluhyaDto> HalleluhyaDetail(@PathVariable int id ){
//        return new Halleluhya(id, "diana", "integration engineer");
        return ResponseEntity.ok(halleluhyaService.getHalleluhyaid(id));
    }

    @PostMapping("/Halleluhya/create")
    @ResponseStatus(HttpStatus.CREATED)////)
//    ResponseEntity<Halleluhya> (@RequestBody Halleluhya halleluhya)
    public ResponseEntity<HalleluhyaDto> createHalleluhya(@RequestBody HalleluhyaDto halleluhyaDto){
//        System.out.println(halleluhya.getName());
//        System.out.println(halleluhya.getOccupation());
//        return new ResponseEntity<>(halleluhya, HttpStatus.CREATED);
        return new ResponseEntity<>(halleluhyaService.createHalleluhya(halleluhyaDto), HttpStatus.CREATED);
    }

    @PutMapping("Halleluhya/{id}/update")
//initially was halleluhya
    public ResponseEntity<HalleluhyaDto> updateHalleluhya(@RequestBody HalleluhyaDto halleluhyaDto, @PathVariable("id") int halleid){
        HalleluhyaDto response = halleluhyaService.updatehalleluhya(halleluhyaDto, halleid);
        return ResponseEntity.ok(response);
//        System.out.println(halleluhya.getName());
//        System.out.println(halleluhya.getOccupation());
//        return ResponseEntity.ok(halleluhya);
    }
    @DeleteMapping("Halleluhya/{id}/delete")
    public ResponseEntity<String> deletehalleluhya(@PathVariable("id") int haleid){
//        System.out.println(haleid);
//        return ResponseEntity.ok("halleluhya deleted succesfully");
        halleluhyaService.deletehalleid(haleid);
        return new ResponseEntity<>("halle has been deleted", HttpStatus.OK);
    }
}
