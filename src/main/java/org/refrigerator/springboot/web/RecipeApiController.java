package org.refrigerator.springboot.web;

import lombok.RequiredArgsConstructor;
import org.refrigerator.springboot.service.recipe.RecipeService;
import org.refrigerator.springboot.web.dto.recipe.RecipeResponseDto;
import org.refrigerator.springboot.web.dto.recipe.RecipeSaveRequestDto;
import org.refrigerator.springboot.web.dto.recipe.RecipeSearchRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RecipeApiController {
    private final RecipeService recipeService;
    @PostMapping("/api/v1/recipe/save")
    public Long save(@RequestBody RecipeSaveRequestDto requestDto) { return recipeService.save(requestDto);}

    @GetMapping("/api/v1/recipe/search")
    public List<RecipeResponseDto> search(@RequestBody RecipeSearchRequestDto requestDto) { return recipeService.search(requestDto);}
}
