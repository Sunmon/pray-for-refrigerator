package org.refrigerator.springboot.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.refrigerator.springboot.domain.posts.PostsRepository;
import org.refrigerator.springboot.domain.recipe.*;
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
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Test
    public void 음식_재료_Repository로_직접_저장된다(){
        Food food = Food.builder().name("김볶밥").build();
        Ingredient ingredient = Ingredient.builder().name("김치").build();
        foodRepository.save(food);
        ingredientRepository.save(ingredient);
        Recipe recipe = Recipe.builder()
                .food(food)
                .ingredient(ingredient)
                .build();
        recipeRepository.save(recipe);

        //when
        Food foodEntity = foodRepository.findByName("김볶밥").get();
//        Recipe recipeEntity = recipeRepository.findAll().get(0);
        Recipe recipeEntity = recipeRepository.findById(1L).get();
        //then
        assertThat(foodEntity.getName()).isEqualTo("김볶밥");
        assertThat(foodEntity.getId()).isEqualTo(1L);
        assertThat(recipeEntity.getFood().getName()).isEqualTo("김볶밥");
        assertThat(recipeEntity.getId()).isEqualTo(1L);
    }

    //fixme: 얘부터 해결
    //혹시 연동은 string name으로 하고 entity로 저장해놔서 그런가??
    @Test
    public void 음식과_재료가_이미_저장되어있을때_DTO_toEntity_테스트(){
        //given
        String foodName= "김볶밥";
        String ingredientName = "김치";
        Food food = Food.builder().name(foodName).build();
        Ingredient ingredient = Ingredient.builder().name(ingredientName).build();
//        foodRepository.save(food);
        foodRepository.saveAndFlush(food);
        ingredientRepository.saveAndFlush(ingredient);
        //TODO: dto에서 찾아오지말고 그냥 food service만들어서 찾아오면?

//        //test
//        //then
//        Food foodEntity = foodRepository.findByName(foodName).get();
//        assertThat(foodEntity.getName()).isEqualTo(foodName);
//        assertThat(foodEntity.getId()).isEqualTo(1L);
//
        //when
        RecipeSaveRequestDto requestDto = RecipeSaveRequestDto.builder()
                .food(foodName)
                .ingredient(ingredientName)
                .build();



        //assert
//        assertThat(requestDto.getFood()).isEqualTo(foodName);
//        assertThat(requestDto.getIngredient()).isEqualTo(ingredientName);
        requestDto.toEntity();
//        Recipe recipe = requestDto.toEntity();
//        recipeRepository.save(_recipe);
//
//        //when
//        Recipe recipeEntity = recipeRepository.findAll().get(0);
//
//        //then
//        assertThat(requestDto.getFood()).isEqualTo(food);
//
////        assertThat(_recipe.getId()).isGreaterThan(0L);
    }
    //fixme: 얘부터 해결
    @Test
    public void 음식과_재료가_이미_저장되어있을때_레시피_서비스로_레시피가_저장된다(){
        //given
        String food= "김볶밥";
        String ingredient = "김치";
        Food _food = Food.builder().name(food).build();
        Ingredient _ingredient = Ingredient.builder().name(ingredient).build();
        foodRepository.save(_food);
        ingredientRepository.save(_ingredient);

        //when
//        List<Food> foodList = foodRepository.findAll();
//        Food foodEntity = foodRepository.findByName(food).get();

        //then
//        Food _food = foodList.get(0);
//        assertThat(foodEntity.getName()).isEqualTo("김볶밥");
//
        RecipeSaveRequestDto requestDto = RecipeSaveRequestDto.builder()
                .food(food)
                .ingredient(ingredient)
                .build();
        //when


        //when
//        Long id = recipeService.save(requestDto);
//
//        List<Recipe> recipeList = recipeRepository.findAll();
//        assertThat(recipeList.get(0).getFood().getName()).isEqualTo("김볶밥");
    }


    //FIXME:
    @Test
    public void 레시피_Dto_저장하면_음식_재료_Dto도_저장된다(){
        //given
        String food = "김볶밥";
        String ingredient = "김치";
        RecipeSaveRequestDto requestDto = RecipeSaveRequestDto.builder()
                .food(food)
                .ingredient(ingredient)
                .build();
        Long id = recipeService.save(requestDto);

        //when
        List<Recipe> recipeList = recipeRepository.findAll();
        List<Ingredient> ingredientList = ingredientRepository.findAll();

        //then
        assertThat(id).isEqualTo(1);
//        assertThat(recipeList.get(0).getIngredient().getName()).isEqualTo("김치");
//        Ingredient result = ingredientList.get(0);
//        assertThat(result.getName()).isEqualTo("김치");
    }

    //FIXME:
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
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);

//        List<Recipe> all = recipeRepository.findAll();
//        assertThat(all.get(0).getFood()).isEqualTo(food);
//        assertThat(all.get(0).getIngredient()).isEqualTo(ingredient);

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