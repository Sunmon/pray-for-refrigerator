package org.refrigerator.springboot.domain.recipe;


import org.refrigerator.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findByName(String name);

//    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")

//    List<Posts> findAllDesc();

//    Food

//    findByName(String name);
}
