package org.refrigerator.springboot.web.dto.recipe;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RecipeSaveRequestDto {

    private String food;
    private String ingredient;
    private boolean mainMaterial;

    @Builder
    public RecipeSaveRequestDto(String food, String ingredient, boolean mainMaterial){
        this.food = food;
        this.ingredient = ingredient;
        this.mainMaterial = mainMaterial;
    }
}
