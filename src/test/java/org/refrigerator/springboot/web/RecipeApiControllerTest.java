package org.refrigerator.springboot.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.*;
import org.junit.runner.RunWith;
import org.refrigerator.springboot.domain.recipe.*;
import org.refrigerator.springboot.service.recipe.RecipeService;
import org.refrigerator.springboot.web.dto.recipe.RecipeResponseDto;
import org.refrigerator.springboot.web.dto.recipe.RecipeSaveRequestDto;
import org.refrigerator.springboot.web.dto.recipe.RecipeSearchRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@DataJdbcTest
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RecipeApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private FoodRepository foodRepository;

//    private PostsRepository postsRepository;

    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;

    @Before
    public void setup(){
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();

    }

    @After
    public void tearDown() throws Exception {
        recipeRepository.deleteAll();
    }

    @Test
    public void 음식_재료_Repository로_직접_저장된다(){
        Food food;
        Ingredient ingredient;

        food = Food.builder().name("김볶밥").build();
        ingredient = Ingredient.builder().name("김치").build();
        foodRepository.save(food);
        ingredientRepository.save(ingredient);

        Recipe recipe = Recipe.builder()
                .food(food)
                .ingredient(ingredient)
                .build();
        recipeRepository.save(recipe);

        //when
        Food foodEntity = foodRepository.findByName("김볶밥");
        Recipe recipeEntity = recipeRepository.findById(1L).get();
        //then
        assertThat(foodEntity.getName()).isEqualTo("김볶밥");
        assertThat(foodEntity.getId()).isEqualTo(1L);
        assertThat(recipeEntity.getFood().getName()).isEqualTo("김볶밥");
        assertThat(recipeEntity.getId()).isEqualTo(1L);
    }

    @Test
    public void 음식과_재료가_이미_저장되어있을때_RecipeDTO_저장테스트(){
        //given
        String foodName= "김볶밥";
        String ingredientName = "김치";
        Food food = Food.builder().name("김볶밥").build();
        Ingredient ingredient = Ingredient.builder().name("김치").build();
        foodRepository.save(food);
        ingredientRepository.save(ingredient);

        //when
        RecipeSaveRequestDto requestDto = RecipeSaveRequestDto.builder()
                .food(foodName)
                .ingredient(ingredientName)
                .build();
        recipeService.save(requestDto);


        //then
        Recipe recipe = recipeRepository.findAll().get(0);
        assertThat(recipe.getFood().getName()).isEqualTo(foodName);
        assertThat(recipe.getIngredient().getName()).isEqualTo(ingredientName);
    }

    @Test
    @WithMockUser(roles="USER")
    public void 음식과_재료가_이미_저장되어있을때_레시피Api로_레시피가_저장된다() throws Exception {
        //given
        String foodName= "김볶밥";
        String ingredientName = "김치";
        Food food = Food.builder().name("김볶밥").build();
        Ingredient ingredient = Ingredient.builder().name("김치").build();
        foodRepository.save(food);
        ingredientRepository.save(ingredient);
        RecipeSaveRequestDto requestDto = RecipeSaveRequestDto.builder()
                .food(foodName)
                .ingredient(ingredientName)
                .build();
        String url = "http://localhost:" + port + "/api/v1/recipe/save";


        //when
        //MockMvc로 api 테스트
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Recipe> all = recipeRepository.findAll();
        assertThat(all.get(0).getFood().getName()).isEqualTo(foodName);
    }

    @Test
    @WithMockUser(roles = "USER")
    public void 음식과_재료가_없으면_새로_모두_저장된다() throws Exception{
        //given
        String food = "김볶밥";
        String ingredient = "김치";
        RecipeSaveRequestDto requestDto = RecipeSaveRequestDto.builder()
                .food(food)
                .ingredient(ingredient)
                .build();
        String url = "http://localhost:" + port + "/api/v1/recipe/save";

        //MockMvc로 api 테스트
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());
        //when
        //TODO: 관리자만 추가할 수 있도록 하기
        List<Recipe> all = recipeRepository.findAll();
        assertThat(all.get(0).getFood().getName()).isEqualTo(food);
        assertThat(all.get(0).getIngredient().getName()).isEqualTo(ingredient);

        List<Food> fAll = foodRepository.findAll();
        assertThat(fAll.get(0).getName()).isEqualTo(food);
    }

    //TODO: 엔티티 주요 재료로 저장
    private void 음식_setup(){
        //given
        String food = "잔치국수";
        String[] ingredients = {"국수", "김치", "계란"};
        for(String ingredient : ingredients){
            boolean mainMaterial = false;

            if(ingredient.equals("국수")) mainMaterial = true;
            RecipeSaveRequestDto requestDto = RecipeSaveRequestDto.builder()
                .food(food)
                .ingredient(ingredient)
                .mainMaterial(mainMaterial)
                .build();
            recipeService.save(requestDto);
        }

        String food2 = "잔치라면";
        String[] ingredients2 = {"라면", "김치", "계란", "파"};
        for(String ingredient : ingredients){
            boolean mainMaterial = false;
            if(ingredient.equals("라면")) mainMaterial = true;
            RecipeSaveRequestDto requestDto = RecipeSaveRequestDto.builder()
                    .food(food)
                    .ingredient(ingredient)
                    .mainMaterial(mainMaterial)
                    .build();
            recipeService.save(requestDto);
        }

        String food3 = "삼겹살구이";
        String[] ingredients3 = {"삼겹살", "파", "마늘"};
        for(String ingredient : ingredients){
            boolean mainMaterial = false;
            if(ingredient.equals("삼겹살")) mainMaterial = true;
            RecipeSaveRequestDto requestDto = RecipeSaveRequestDto.builder()
                    .food(food)
                    .ingredient(ingredient)
                    .mainMaterial(mainMaterial)
                    .build();
            recipeService.save(requestDto);
        }
    }

    //TODO: 검색버튼 누르면 검색결과 리턴
    @Test
    @WithMockUser(roles="USER")
    public void 레시피_키워드_검색_테스트() throws Exception{
        //given
        this.음식_setup();

        //TODO: submit하면 post형식으로 들어온다는데 그게 뭔말임? searchString이 들어온단건가?
        String searchString = "삼겹살, 라면, 파";
        RecipeSearchRequestDto requestDto = RecipeSearchRequestDto.builder().searchString(searchString).build();
        List<RecipeResponseDto> results = recipeService.search(requestDto);


        //then
        //레시피중에 삼겹살 || 라면 || 파 들어가는 음식 리턴
        List<Recipe> all = recipeRepository.findAll();
        assertThat(all.get(0).getIngredient().getName()).isSubstringOf(searchString);
    }

    //FIXME:
    @Test
    @WithMockUser(roles = "USER")
    public void 검색하면_나온다() throws Exception{
        //given
        this.음식_setup();

        //TODO: submit하면 post형식으로 들어온다는데 그게 뭔말임? searchString이 들어온단건가?
        String searchString = "삼겹살, 라면, 파";
        RecipeSearchRequestDto requestDto = RecipeSearchRequestDto.builder().searchString(searchString).build();




        String url = "http://localhost:" + port + "/api/v1/recipe/search";

        //MockMvc로 api 테스트
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //when
        //레시피중에 삼겹살 || 라면 || 파 들어가는 음식 리턴
        List<Recipe> all = recipeRepository.findAll();
        assertThat(all.get(0).getIngredient().getName()).isSubstringOf(searchString);
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