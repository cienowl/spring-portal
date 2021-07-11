package io.string.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WebMainController {

    @GetMapping("/")
    public String viewIndex() {
        return "index";
    }

}
