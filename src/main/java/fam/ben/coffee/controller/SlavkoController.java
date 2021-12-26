package fam.ben.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/slavko")
public class SlavkoController {

    @GetMapping
    public String slavko() {
        return "slavko";
    }

}
