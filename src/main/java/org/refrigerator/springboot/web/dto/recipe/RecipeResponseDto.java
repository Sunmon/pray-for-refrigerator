package org.refrigerator.springboot.web.dto.recipe;

import lombok.Getter;
import org.refrigerator.springboot.domain.recipe.Food;
import org.refrigerator.springboot.domain.recipe.Ingredient;
import org.refrigerator.springboot.domain.recipe.Recipe;

import javax.persistence.*;

@Getter
public class RecipeResponseDto {

    private Long id;
    private String food;
    private String ingredient;

    public RecipeResponseDto(Recipe entity) {
        this.id = entity.getId();
        this.food = entity.getFood().getName();
        this.ingredient = entity.getIngredient().getName();
    }
}
