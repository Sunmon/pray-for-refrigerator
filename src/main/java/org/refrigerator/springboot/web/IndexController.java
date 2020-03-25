package org.refrigerator.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        //src/main/resources/templates/index.mustache로 전환
        //mustache starter있어서 앞경로 / 뒤 .mustache 는 자동으로 붙음
        return "index";
    }
}
