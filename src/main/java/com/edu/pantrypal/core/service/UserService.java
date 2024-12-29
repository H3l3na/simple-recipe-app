package src.main.java.com.edu.pantrypal.core.service;

import org.springframework.stereotype.Service;
import src.main.java.com.edu.pantrypal.core.mapping.UserMapper;
import src.main.java.com.edu.pantrypal.core.model.User;
import src.main.java.com.edu.pantrypal.core.repository.UserRepository;
import src.main.java.com.edu.pantrypal.rest.dto.UserDTO;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserDTO dto) {
        User user = UserMapper.toEntity(dto);

        return userRepository.save(user);
    }

    public UserDTO getUserById(Long userId) {
        User user = userRepository.findByUserId(userId);

        return UserMapper.toDTO(user);
    }
}
