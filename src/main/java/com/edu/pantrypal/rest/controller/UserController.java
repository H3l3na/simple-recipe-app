package com.edu.pantrypal.rest.controller;

import com.edu.pantrypal.core.model.User;
import com.edu.pantrypal.core.service.RecipeService;
import com.edu.pantrypal.core.service.UserService;
import com.edu.pantrypal.rest.dto.RecipeDTO;
import com.edu.pantrypal.rest.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
//@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserService userService;
    private final RecipeService recipeService;

    public UserController(UserService userService, RecipeService recipeService) {
        this.userService = userService;
        this.recipeService = recipeService;
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        User user = userService.createUser(userDTO);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/{userId}/favorite")
    public ResponseEntity<String> favoriteRecipe(@PathVariable Long userId, @RequestBody RecipeDTO recipeDTO) {
        recipeService.addToFavorites(userId, recipeDTO.getRecipeId());
        return ResponseEntity.ok("Recipe added to favorites successfully.");
    }
}

