package org.refrigerator.springboot.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.refrigerator.springboot.domain.posts.PostsRepository;
import org.refrigerator.springboot.domain.recipe.Recipe;
import org.refrigerator.springboot.domain.recipe.RecipeRepository;
import org.refrigerator.springboot.service.recipe.RecipeService;
import org.refrigerator.springboot.web.dto.RecipeSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RecipeApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RecipeRepository recipeRepository;
//    private PostsRepository postsRepository;

//    @Autowired
//    private WebApplicationContext context;
//    private MockMvc mvc;

//    @Before
//    public void setup(){
//        mvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();
//    }

    @Before
    public void setup(){

    }
    @After
    public void tearDown() throws Exception {
        recipeRepository.deleteAll();
    }

    @Test
    public void 레시피_음식_재료까지_새로_등록된다() throws Exception{
        //TODO: 레시피가 입력된다
        //given
        String food = "김볶밥";
        String ingredient = "김치";
        RecipeSaveRequestDto requestDto = RecipeSaveRequestDto.builder()
                .food(food)
                .ingredient(ingredient)
                .build();
        String url = "http://localhost:" + port + "/api/v1/recipe";

        //when
        //TODO: 관리자만 추가할 수 있도록 하기
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Recipe> all = recipeRepository.findAll();
        assertThat(all.get(0).getFood()).isEqualTo(food);
        assertThat(all.get(0).getIngredient()).isEqualTo(ingredient);

    }


//    @Test
//    public void 레시피에_들어가는_음식_엔티티_리턴된다(){
//        //given
//        String food = "김볶밥";
//        String ingredient = "김치";
//
////        RecipeSaveRequestDto requestDto = RecipeSaveRequestDto.builder()
////                .food(food)
////                .ingredient(ingredient)
////                .build();
//        String url = "http://localhost:" + port + "/api/v1/recipe";
//
//        //when
//        //TODO: 관리자만 추가할 수 있도록 하기
//        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
//
//        //then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//        List<Recipe> all = recipeRepository.findAll();
//        assertThat(all.get(0).getFood()).isEqualTo(food);
//        assertThat(all.get(0).getIngredient()).isEqualTo(ingredient);
//
//    }





}