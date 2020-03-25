package org.refrigerator.springboot.web;

import lombok.RequiredArgsConstructor;
import org.refrigerator.springboot.service.posts.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){   //Model: 서버 템플릿 엔진에서 사용할수있는 객체 저장
        model.addAttribute("posts", postsService.findAllDesc());

        //src/main/resources/templates/index.mustache로 전환
        //mustache starter있어서 앞경로 / 뒤 .mustache 는 자동으로 붙음
        return "index";
    }

    //저장 화면. posts-save.mustach 호출
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

}
