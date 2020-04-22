package org.refrigerator.springboot.web.dto.recipe;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RecipeSearchRequestDto {
    private String searchString;
    private String[] items;

    @Builder
    public RecipeSearchRequestDto(String searchString){
        this.searchString = searchString;
        items = searchString.split(",");
        for(String item: items) item.trim();
    }
}