package src.main.java.com.edu.pantrypal.core.model;

import jakarta.persistence.*;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    private int stars;
    private String review;

    // Constructor for dependency injection
    public Rating(int stars, String review) {
        this.stars = stars;
        this.review = review;
    }

    // Getters and setters omitted for brevity
}
