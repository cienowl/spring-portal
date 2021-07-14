package io.string.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebMainController {

    @GetMapping("/")
    public String viewIndex() {
        return "index";
    }

    @GetMapping("/intro")
    public String viewIntro() {
        return "intro/intro";
    }

    @GetMapping("/tennis")
    public String viewTennis() {
        return "tennis/tennis";
    }

    @GetMapping("/badminton")
    public String viewBadminton() {
        return "badminton/badminton";
    }

    @GetMapping("/squash")
    public String viewSquash() {
        return "squash/squash";
    }

}
