package org.refrigerator.springboot.web.dto.recipe;

import lombok.*;
import org.refrigerator.springboot.domain.recipe.Ingredient;
import org.refrigerator.springboot.domain.recipe.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//package org.refrigerator.springboot.web.dto;

import lombok.Builder;
import org.refrigerator.springboot.domain.recipe.Ingredient;
import org.refrigerator.springboot.domain.recipe.IngredientRepository;
import org.springframework.stereotype.Service;

//@Getter
//@NoArgsConstructor  //생성자로 Bean 주입받으면 @Autowired 필요 X
@RequiredArgsConstructor
//@AllArgsConstructor
@Service
public class IngredientSaveRequestDto {

//    @Autowired
//    private IngredientRepository ingredientRepository;
    private String name;
    private String category;

    @Builder
    public IngredientSaveRequestDto(String name, String category){
        this.name = name;
        this.category = category;
    }

//    public int getSize(){
//        return ingredientRepository.findAll().size();
//    }
    public Ingredient toEntity(){
        return Ingredient.builder().name(name).category(category).build();
    }
}
