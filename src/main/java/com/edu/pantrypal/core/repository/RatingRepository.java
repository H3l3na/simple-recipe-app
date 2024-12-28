package src.main.java.com.edu.pantrypal.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import src.main.java.com.edu.pantrypal.core.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
}
