package src.main.java.com.edu.pantrypal.core.mapping;

import src.main.java.com.edu.pantrypal.core.model.User;
import src.main.java.com.edu.pantrypal.rest.dto.UserDTO;

public class UserMapper {

    public static UserDTO toDTO(User user){
        if (user == null){
            return null;
        }

        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());

        return dto;
    }

    public static User toEntity(UserDTO dto){
        if (dto == null){
            return null;
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        return user;
    }
}
