package org.refrigerator.springboot.service.recipe;

import lombok.RequiredArgsConstructor;
import org.refrigerator.springboot.domain.recipe.*;
import org.refrigerator.springboot.web.dto.RecipeSaveRequestDto;
import org.springframework.stereotype.Service;
//import org.jetbrains.annotaions.NotNull;
import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final FoodRepository foodRepository;
    private final IngredientRepository ingredientRepository;

    @Transactional
    public Long save(RecipeSaveRequestDto requestDto) {
        return recipeRepository.save(this.toEntity(requestDto)).getId();
    }

    @Transactional
    public Recipe toEntity(RecipeSaveRequestDto requestDto){
        //음식이름이랑 재료를 검색하여 얻어온다
        Food food = foodRepository.findByName(requestDto.getFood()).get();
        Ingredient ingredient = ingredientRepository.findByName(requestDto.getIngredient()).get();
        return Recipe.builder().food(food).ingredient(ingredient).build();
    }

//    @Transactional
//    public Optional<Food> findByFoodName(String name){
//        return foodRepository.findByName(name);
////                .orElse(saveNewFood(name));
//    }
//
//    @Transactional
//    public Optional<Ingredient> findByIngredientName(String name){
//        return ingredientRepository.findByName(name)
//                .orElse(saveNewIngredient(name));
//    }




}
