package src.main.java.com.edu.pantrypal.core.model;

import jakarta.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredientId;

    private String name;
    private String quantity;

    // Constructor for dependency injection
    public Ingredient(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    // Getters and setters omitted for brevity
}
