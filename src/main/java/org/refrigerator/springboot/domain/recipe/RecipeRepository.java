package org.refrigerator.springboot.domain.recipe;


import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    //TODO: 쿼리 추가

}
