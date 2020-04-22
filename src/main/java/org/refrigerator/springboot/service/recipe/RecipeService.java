package org.refrigerator.springboot.service.recipe;

import lombok.RequiredArgsConstructor;
import org.refrigerator.springboot.domain.recipe.*;
import org.refrigerator.springboot.web.dto.recipe.RecipeResponseDto;
import org.refrigerator.springboot.web.dto.recipe.RecipeSaveRequestDto;
import org.refrigerator.springboot.web.dto.recipe.RecipeSearchRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.jetbrains.annotaions.NotNull;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final FoodRepository foodRepository;
    private final IngredientRepository ingredientRepository;

    @Transactional
    public Recipe toEntity(RecipeSaveRequestDto requestDto){
        //음식이름이랑 재료를 검색하여 얻어온다
        Food food = foodRepository.findByName(requestDto.getFood());
        Ingredient ingredient = ingredientRepository.findByName(requestDto.getIngredient());
        return Recipe.builder().food(food).ingredient(ingredient).build();
    }

    @Transactional
    public Long save(RecipeSaveRequestDto requestDto) {
        Food food = foodRepository.findByName(requestDto.getFood());
        Ingredient ingredient = ingredientRepository.findByName(requestDto.getIngredient());
        if(food == null) foodRepository.save(Food.builder().name(requestDto.getFood()).build());
        if(ingredient == null) ingredientRepository.save(Ingredient.builder().name(requestDto.getIngredient()).build());
//        .orElseGet((Supplier<? extends Food>) saveNewEntity(requestDto.getFood()));
//        if(Food food = foodRepository.findByName(requestDto.getFood()).get());

        return recipeRepository.save(this.toEntity(requestDto)).getId();
    }

    @Transactional(readOnly=true)
    public List<RecipeResponseDto> searchRecipe(RecipeSearchRequestDto requestDto){
        List<RecipeResponseDto> responseDtoList = new ArrayList<>();
        for(String item : requestDto.getItems()){
            responseDtoList.add(new RecipeResponseDto(recipeRepository.findAny(item)));
        }
        return responseDtoList;
    }


//    @Transactional
//    public Optional<Food> saveNewFood(name)
//    public Optional<Food> findByFoodName(String name){
//        return foodRepository.findByName(name);
//                .orElse(saveNewFood(name));
//    }
//
//    @Transactional
//    public Optional<Ingredient> findByIngredientName(String name){
//        return ingredientRepository.findByName(name)
//                .orElse(saveNewIngredient(name));
//    }




}
