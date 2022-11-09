package com.halleluhya.halleluhya.controllers;

import com.halleluhya.halleluhya.models.Halleluhya;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
