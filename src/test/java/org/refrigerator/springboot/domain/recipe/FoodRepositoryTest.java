package org.refrigerator.springboot.domain.recipe;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodRepositoryTest {

    @Autowired
    FoodRepository foodRepository;

    @After  //Junit에서 단위테스트 끝날때마다 수행되는 메소드
    public void cleanup(){ foodRepository.deleteAll(); }

    @Test
    public void 음식저장(){


        //when
        Food food = Food.builder().name("김볶밥").build();
        foodRepository.save(food);

        List<Food> foodList = foodRepository.findAll();

        //then
        Food result = foodList.get(0);
        assertThat(result.getName()).isEqualTo("김볶밥");

    }


}