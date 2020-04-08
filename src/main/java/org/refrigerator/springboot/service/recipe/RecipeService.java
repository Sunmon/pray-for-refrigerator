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
        return recipeRepository.save(requestDto.toEntity()).getId();
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
