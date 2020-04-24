package org.refrigerator.springboot.web;

import lombok.RequiredArgsConstructor;
import org.refrigerator.springboot.config.auth.LoginUser;
import org.refrigerator.springboot.config.auth.dto.SessionUser;
import org.refrigerator.springboot.service.recipe.RecipeService;
import org.refrigerator.springboot.web.dto.recipe.RecipeResponseDto;
import org.refrigerator.springboot.web.dto.recipe.RecipeSaveRequestDto;
import org.refrigerator.springboot.web.dto.recipe.RecipeSearchRequestDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RecipeApiController {
    private final RecipeService recipeService;
    @PostMapping("/api/v1/recipe/save")
    public Long save(@RequestBody RecipeSaveRequestDto requestDto) { return recipeService.save(requestDto);}

    @PostMapping("/api/v1/recipe/search")
    public List<RecipeResponseDto> search(@RequestBody RecipeSearchRequestDto requestDto) { return recipeService.search(requestDto);}

}
