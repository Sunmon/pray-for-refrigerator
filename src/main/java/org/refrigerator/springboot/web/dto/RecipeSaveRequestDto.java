package org.refrigerator.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
