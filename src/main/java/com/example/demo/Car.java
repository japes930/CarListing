package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String make;

    private String model;

    private int year;

    private int msrp;

    @OneToMany(mappedBy = "car")
    private Set<CatCars> catCars;

    public Car() { catCars = new HashSet<>();}

    public long getId(){return id;}

    public void setId(long id){this.id= id;}

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMsrp() {
        return msrp;
    }

    public void setMsrp(int msrp) {
        this.msrp = msrp;
    }

    public Set<CatCars> getCatCars() {
        return catCars;
    }

    public void setCatCars(Set<CatCars> catCars) {
        this.catCars = catCars;
    }
}
