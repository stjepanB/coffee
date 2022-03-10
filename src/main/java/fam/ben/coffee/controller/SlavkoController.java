package fam.ben.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fam.ben.coffee.model.coffee.Pair;

@Controller
@RequestMapping("/slavko")
public class SlavkoController {

    @GetMapping
    public String slavko(Model model) {
        model.addAttribute("project", new Pair());
        return "slavko";
    }

}
