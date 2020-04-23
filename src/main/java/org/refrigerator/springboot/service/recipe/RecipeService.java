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
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;

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
        return Recipe.builder().food(food).ingredient(ingredient).mainMaterial(requestDto.isMainMaterial()).build();
    }

    @Transactional
    public Long save(RecipeSaveRequestDto requestDto) {
        Food food = foodRepository.findByName(requestDto.getFood());
        Ingredient ingredient = ingredientRepository.findByName(requestDto.getIngredient());
        if(food == null) foodRepository.save(Food.builder().name(requestDto.getFood()).build());
        if(ingredient == null) ingredientRepository.save(Ingredient.builder().name(requestDto.getIngredient()).build());
        return recipeRepository.save(this.toEntity(requestDto)).getId();
    }

    @Transactional(readOnly = true)
    public List<RecipeResponseDto> search(RecipeSearchRequestDto requestDto){

        //키워드로 음식 이름 리스트 가져오기
        List<String> names = new ArrayList<>();
        for(String item: requestDto.getItems()){
            names.addAll(recipeRepository.findAnyFoodNameContaining(item));
        }

        //음식 이름 distinct처리
        HashSet<String> temp = new HashSet<String>(names);
        names = new ArrayList<String>(temp);

        //음식 이름으로 recipe entity가져와서 ResponseDto 만들기
        List<RecipeResponseDto> results = new ArrayList<>();
        for(String name:names){
            List<Recipe> recipes = recipeRepository.findRecipeByFoodName(name);
            results.add(new RecipeResponseDto(recipes));
        }
        return results;
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
