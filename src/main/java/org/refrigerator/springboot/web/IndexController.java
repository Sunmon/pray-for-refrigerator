package org.refrigerator.springboot.web;

import lombok.RequiredArgsConstructor;
import org.refrigerator.springboot.config.auth.LoginUser;
import org.refrigerator.springboot.config.auth.dto.SessionUser;
import org.refrigerator.springboot.service.posts.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@RequiredArgsConstructor
@Controller
public class IndexController {


    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        return "index";
    }


    /** 레시피 검색 화면 호출 **/
    @GetMapping("/recipeSearch")
    public String recipeSearch(){return "recipe-search";}
}
