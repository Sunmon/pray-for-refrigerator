package org.refrigerator.springboot.web;

import lombok.RequiredArgsConstructor;
import org.refrigerator.springboot.service.recipe.RecipeService;
import org.refrigerator.springboot.web.dto.RecipeSaveRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RecipeApiController {
    private final RecipeService recipeService;
    @PostMapping("/api/v1/recipe/save")
    public Long save(@RequestBody RecipeSaveRequestDto requestDto) { return recipeService.save(requestDto);}

}
