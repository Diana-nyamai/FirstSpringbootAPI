package com.halleluhya.halleluhya.controllers;

import com.halleluhya.halleluhya.models.Halleluhya;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class Hallecontroller {
    @GetMapping("Halleluhya")
    public ResponseEntity<List<Halleluhya>> getHalleluhyas(){
      List<Halleluhya> halleluhyas = new ArrayList<>();
      halleluhyas.add(new Halleluhya(1,"ndinda", "software developer"));
      halleluhyas.add(new Halleluhya(2,"diana", "web developer"));
      halleluhyas.add(new Halleluhya(3,"fiona", "advocate"));
      return ResponseEntity.ok(halleluhyas);
    }

    @GetMapping("/Halleluhya/{id}")
    public Halleluhya HalleluhyaDetail(@PathVariable int id ){
        return new Halleluhya(id, "diana", "integration engineer");
    }

    @PostMapping("/Halleluhya/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Halleluhya> createHalleluhya(@RequestBody Halleluhya halleluhya){
        System.out.println(halleluhya.getName());
        System.out.println(halleluhya.getOccupation());
        return new ResponseEntity<>(halleluhya, HttpStatus.CREATED);
    }

    @PutMapping("Halleluhya/{id}/update")
    public ResponseEntity<Halleluhya> updateHalleluhya(@RequestBody Halleluhya halleluhya, @PathVariable("id") int halleid){
        System.out.println(halleluhya.getName());
        System.out.println(halleluhya.getOccupation());
        return ResponseEntity.ok(halleluhya);
    }
    @DeleteMapping("Halleluhya/{id}/delete")
    public ResponseEntity<String> deletehalleluhya(@PathVariable("id") int haleid){
        System.out.println(haleid);
        return ResponseEntity.ok("halleluhya deleted succesfully");
    }
}
