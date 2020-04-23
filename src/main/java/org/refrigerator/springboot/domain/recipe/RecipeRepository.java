package org.refrigerator.springboot.domain.recipe;


import org.refrigerator.springboot.web.dto.recipe.RecipeResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByFood(Food food);
    List<Recipe> findByMainMaterial(boolean material);

    @Query("SELECT r FROM Recipe r WHERE r.food.name = :name")
    List<Recipe> findRecipeByFoodName(@Param("name") String foodName);

    @Query("SELECT DISTINCT r.food.name FROM Recipe r " +
            "WHERE r.food.name LIKE %:item% " +
            "OR (r.ingredient.name = :item AND r.mainMaterial = true)")
    List<String> findAnyFoodNameContaining(@Param("item") String item);
}
