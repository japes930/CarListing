package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String type;

    @OneToMany(mappedBy = "category")
    private Set<CatCars> catCars;

    public Category(){
        catCars = new HashSet<>();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<CatCars> getCatCars() {
        return catCars;
    }

    public void setCatCars(Set<CatCars> catCars) {
        this.catCars = catCars;
    }
}
