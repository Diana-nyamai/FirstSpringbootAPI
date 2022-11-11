package com.halleluhya.halleluhya.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Halleluhya {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String occupation;

    @OneToMany(mappedBy = "halleluhya", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> review = new ArrayList<Review>();

}
