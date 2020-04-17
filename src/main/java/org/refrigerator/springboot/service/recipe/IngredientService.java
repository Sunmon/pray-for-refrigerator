package org.refrigerator.springboot.service.recipe;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.refrigerator.springboot.domain.recipe.*;
import org.refrigerator.springboot.web.dto.IngredientSaveRequestDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Getter
@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

//    public IngredientService(IngredientRepository ingredientRepository) {
//        this.ingredientRepository = ingredientRepository;
//    }

    @Transactional
    public Long save(IngredientSaveRequestDto requestDto) {
        return ingredientRepository.save(requestDto.toEntity()).getId();
    }

    //test
    @Transactional
    public int getSize(){
        return ingredientRepository.findAll().size();
    }
}
