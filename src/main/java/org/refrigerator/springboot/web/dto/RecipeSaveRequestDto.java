package org.refrigerator.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.refrigerator.springboot.domain.recipe.*;
import org.refrigerator.springboot.service.recipe.IngredientService;
import org.refrigerator.springboot.service.recipe.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Getter
@NoArgsConstructor
public class RecipeSaveRequestDto {

    private String food;
    private String ingredient;

    @Builder
    public RecipeSaveRequestDto(String food, String ingredient){
        this.food = food;
        this.ingredient = ingredient;
    }

}
