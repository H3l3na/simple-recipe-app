package com.edu.pantrypal.core.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MealService {

    private final WebClient webClient;

    public MealService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://www.themealdb.com/api/json/v1/1").build();
    }

    public String getMealByName(String name) {
        return webClient.get()
                .uri("/search.php?s={name}", name)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getMealById(String id) {
        return webClient.get()
                .uri("/lookup.php?i={id}", id)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getRandomMeal() {
        return webClient.get()
                .uri("/random.php")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}

