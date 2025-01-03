package com.edu.pantrypal.core.mapping;

import com.edu.pantrypal.core.model.Ingredient;
import com.edu.pantrypal.rest.dto.IngredientDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class IngredientMapper {

    public static List<IngredientDTO> toDTO(List<Ingredient> ingredients){
        if (ingredients == null) {
            return null;
        }

        return ingredients.stream()
                .map(IngredientMapper::toDTO)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static IngredientDTO toDTO(Ingredient ingredient){
        if (ingredient == null){
            return null;
        }

        IngredientDTO dto = new IngredientDTO();
        dto.setRecipeId(ingredient.getRecipeId());
        dto.setQuantity(ingredient.getQuantity());
        dto.setName(ingredient.getName());

        return dto;
    }

    public static Ingredient toEntity(IngredientDTO dto){
        if (dto == null){
            return null;
        }

        Ingredient ingredient = new Ingredient();
        ingredient.setRecipeId(dto.getRecipeId());
        ingredient.setQuantity(dto.getQuantity());
        ingredient.setName(dto.getName());

        return ingredient;
    }
}
