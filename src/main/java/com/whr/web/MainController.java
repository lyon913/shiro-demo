package com.whr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lyon on 2017/7/10.
 */
@Controller
public class MainController {
    @RequestMapping("/main")
    public String homePage(){
        return "main/main";
    }
}
