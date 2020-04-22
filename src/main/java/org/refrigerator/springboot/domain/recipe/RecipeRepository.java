package org.refrigerator.springboot.domain.recipe;


import org.refrigerator.springboot.web.dto.recipe.RecipeResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
//    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
//    @Query("SELECT ")
    List<Food> findByFood(String name);

//    List<Food> findByFood(Food food);

    //TODO: query 만들기
    //이 쿼리 그대로 H2에 날려보자. 어떻게 나오냐?
//    @Query("SELECT r FROM Recipe r " +
//            "WHERE r.food LIKE %:item% or r.ingredient LIKE %:item%" +
//            "ORDER BY r.food, r.mainMaterial DESC")
//    List<Recipe> findAny(@Param("item") String item);


//    @Query("SELECT r FROM Recipe r WHERE r.food in :")
//    List<Recipe> findAny(@Param("items") String[] items);

    List<Recipe> findByFoodContaining(String item);
    List<Recipe> findByIngredientContaining(String item);

}
