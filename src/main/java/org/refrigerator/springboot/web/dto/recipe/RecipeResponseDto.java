package org.refrigerator.springboot.web.dto.recipe;

import lombok.Getter;
import org.refrigerator.springboot.domain.recipe.Food;
import org.refrigerator.springboot.domain.recipe.Ingredient;
import org.refrigerator.springboot.domain.recipe.Recipe;

import javax.persistence.*;
import java.util.List;

@Getter
public class RecipeResponseDto {

    private List<Long> id;
    private String food;
    private List<String> ingredient;

    public RecipeResponseDto(List<Recipe> entityList) {
        for(Recipe entity : entityList){
            this.id.add(entity.getId());
            this.food = entity.getFood().getName();
            this.ingredient.add(entity.getIngredient().getName());
        }
    }
}
