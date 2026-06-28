package com.org.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringMemberController {

    @GetMapping("/member/new")
    public String newForm() {
        return "new-form";
    }
}
