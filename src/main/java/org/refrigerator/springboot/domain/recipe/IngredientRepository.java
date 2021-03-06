package org.refrigerator.springboot.domain.recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Ingredient findByName(String ingredientName);
}
