package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CatCarsRepository catCarsRepository;

    @RequestMapping("/")
    public String index(Model model)
    {
        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("catCars", catCarsRepository.findAll());
        return "index";
    }

    @GetMapping("/addcar")
    public String addCar(Model model){
        model.addAttribute("car", new Car());
        model.addAttribute("category", categoryRepository.findAll());
        return "car";
    }

    @PostMapping("/processcar")
    public String processForm(@ModelAttribute("car") Car car,
                              @RequestParam("catCars") long... ids)
    {
        for(long id : ids){
            Category category = categoryRepository.findById(id).get();
            CatCars catCars = new CatCars(category, car);
            carRepository.save(car);
            catCarsRepository.save(catCars);
        }
        return "redirect:/";
    }

    @GetMapping("/addcategory")
    public String categoryForm(Model model){
        model.addAttribute("category", new Category());
        return "category";
    }

    @PostMapping("/processcategory")
    public String saveCategory(@Valid Category category, Model model)
    {
        categoryRepository.save(category);
        return "redirect:/";
    }


    @PostConstruct
    public void fillTables(){
        Category category = new Category();
        category.setType("SUV");
        categoryRepository.save(category);

        category = new Category();
        category.setType("Sedan");
        categoryRepository.save(category);

        category = new Category();
        category.setType("Hatchback");
        categoryRepository.save(category);

        category = new Category();
        category.setType("Coupe");
        categoryRepository.save(category);


    }


}
