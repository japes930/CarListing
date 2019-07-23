package com.example.demo;

import javax.persistence.*;

@Entity
public class CatCars {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Car car;


    public CatCars(){
        category = new Category();
        car = new Car();
    }

    public CatCars(Category category, Car car){
        this.category=category;
        this.car = car;
    }





    private long getId(){
        return id;
    }

    private void setId(long id){
        this.id= id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
