package com.edu.pantrypal.core.repository;

import com.edu.pantrypal.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(Long userId);

    User save(User user);
}
