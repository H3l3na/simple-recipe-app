package src.main.java.com.edu.pantrypal.core.service;

import org.springframework.stereotype.Service;
import src.main.java.com.edu.pantrypal.core.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
