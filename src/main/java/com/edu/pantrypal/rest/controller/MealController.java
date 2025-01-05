package com.edu.pantrypal.rest.controller;

import com.edu.pantrypal.core.service.MealService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/themealdb")
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/meal/search/{name}")
    public String searchMeal(@PathVariable String name) {
        return mealService.getMealByName(name);
    }

    @GetMapping("/meal")
    public String getMeal(@RequestParam String id) {
        return mealService.getMealById(id);
    }

    @GetMapping("/meal/random")
    public String getRandomMeal() {
        return mealService.getRandomMeal();
    }
}
