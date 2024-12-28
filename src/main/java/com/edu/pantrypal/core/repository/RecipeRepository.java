package src.main.java.com.edu.pantrypal.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import src.main.java.com.edu.pantrypal.core.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}

