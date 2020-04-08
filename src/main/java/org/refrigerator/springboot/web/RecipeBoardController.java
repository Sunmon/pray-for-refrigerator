/**
 * @class 레시피 게시판 컨트롤러
 */
package org.refrigerator.springboot.web;

import lombok.RequiredArgsConstructor;
import org.refrigerator.springboot.config.auth.LoginUser;
import org.refrigerator.springboot.config.auth.dto.SessionUser;
import org.refrigerator.springboot.service.posts.PostsService;
import org.refrigerator.springboot.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequiredArgsConstructor
@Controller
public class RecipeBoardController {

    private final PostsService postsService;

    @GetMapping("/recipeBoard")
    public String recipeBoard(Model model, @LoginUser SessionUser user){
        /**
         * Model: 서버 템플릿 엔진에서 사용할수있는 객체 저장
         * LoginUser : (User) httpSession.getUser("user")를 어노테이션으로.
         */
        model.addAttribute("posts", postsService.findAllDesc());
        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
        //src/main/resources/templates/index.mustache로 전환
        //mustache starter있어서 앞경로 / 뒤 .mustache 는 자동으로 붙음
        return "recipe-board";
    }


    /** 저장 화면. posts-save.mustach 호출 **/
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    /** 게시글 수정 **/
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }




}
