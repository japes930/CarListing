package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface CatCarsRepository extends CrudRepository<CatCars, Long>{

    Iterable<CatCars> findAllByCategory_Id(Long category_id);
}
