package org.refrigerator.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.refrigerator.springboot.domain.recipe.*;
import org.refrigerator.springboot.service.recipe.RecipeService;

import javax.persistence.*;

@Getter
@NoArgsConstructor  //생성자로 Bean 주입받으면 @Autowired 필요 X
public class RecipeSaveRequestDto {

    private Long id;
//    private Food food;
//    private Ingredient ingredient;
    private String food;
    private String ingredient;

    private FoodRepository foodRepository;
    private IngredientRepository ingredientRepository;
//    RecipeService recipeService;

    @Builder
    public RecipeSaveRequestDto(String food, String ingredient){
        this.food = food;
        this.ingredient = ingredient;
    }

    public Recipe toEntity(){
        //TODO: food, ingredient가 있으면 그걸 가져오고
        Food foodEntity = foodRepository.findByName(food).orElseGet(()->saveNewFood(food));
        Ingredient ingredientEntity = ingredientRepository.findByName(ingredient).orElseGet(()->saveNewIngredient(ingredient));

        return Recipe.builder().food(foodEntity).ingredient(ingredientEntity).build();
        //없으면 새로 만든다.
//        return null;
    }

    public Ingredient saveNewIngredient(String name){
        Ingredient ingredient = Ingredient.builder().name(name).build();
        ingredientRepository.save(ingredient);
        return ingredient;
    }

    public Food saveNewFood(String name){
        Food food = Food.builder().name(name).build();
        foodRepository.save(food);
        return food;
    }

}
