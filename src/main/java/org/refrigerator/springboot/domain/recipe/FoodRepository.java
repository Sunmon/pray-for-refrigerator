package org.refrigerator.springboot.domain.recipe;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface FoodRepository extends JpaRepository<Food, Long> {
    Optional<Food> findByName(String name);

//    findByName(String name);
}
