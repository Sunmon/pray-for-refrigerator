package org.refrigerator.springboot.web.dto.recipe;

import lombok.Getter;
import org.refrigerator.springboot.domain.recipe.Food;
import org.refrigerator.springboot.domain.recipe.Ingredient;
import org.refrigerator.springboot.domain.recipe.Recipe;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Getter
public class RecipeResponseDto {

    private List<Long> id;  //필요없을듯
    private String food;
    private List<String> ingredient;
    private String category;    //음식 카테고리(밥,죽,떡...)

    public RecipeResponseDto(List<Recipe> entityList) {
        this.id = entityList.stream()
                .map(Recipe::getId)
                .collect(Collectors.toList());
        this.ingredient = entityList.stream()
                .map(recipe -> recipe.getIngredient().getName())
                .collect(Collectors.toList());
        this.food = entityList.get(0).getFood().getName();
        this.category = entityList.get(0).getFood().getCategory();
//        this.ingredient = new ArrayList<>();
//        this.id = new ArrayList<>();
//        for(Recipe entity : entityList){
//            this.id.add(entity.getId());
//            this.ingredient.add(entity.getIngredient().getName());
//        }
    }
}
