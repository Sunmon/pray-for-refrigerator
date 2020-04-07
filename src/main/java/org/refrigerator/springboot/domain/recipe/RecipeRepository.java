package org.refrigerator.springboot.domain.recipe;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    //TODO: 쿼리 추가
//    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
//    @Query
    List<Food> findByFood_Name(String name);

    List<Food> findByFood(Food food);




}
