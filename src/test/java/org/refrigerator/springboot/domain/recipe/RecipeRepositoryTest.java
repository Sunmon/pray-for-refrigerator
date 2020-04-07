package org.refrigerator.springboot.domain.recipe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeRepositoryTest {

    Food food;
    Ingredient ingredient;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Before
    public void setup(){
        food = Food.builder().name("김볶밥").build();
        ingredient = Ingredient.builder().name("김치").build();
        foodRepository.save(food);
        ingredientRepository.save(ingredient);
    }

    @After
    public void cleanup(){recipeRepository.deleteAll();}

    @Test
    public void 음식저장_불러오기(){
        //given
        recipeRepository.save(Recipe.builder().food(food).ingredient(ingredient).build());
        //when
        List<Recipe> recipeList = recipeRepository.findAll();
        //then
        Recipe recipe = recipeList.get(0);
        assertThat(recipe.getFood().getName()).isEqualTo("김볶밥");
        assertThat(recipe.getIngredient().getName()).isEqualTo("김치");
    }
}