package fam.ben.coffee.controller.coffee;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fam.ben.coffee.model.coffee.Pair;
import fam.ben.coffee.service.coffee.PairService;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {

    PairService pairService;

    @Autowired
    public CoffeeController(final PairService pairService) {
        this.pairService = pairService;
    }

    @GetMapping("/pairs")
    public String getPairs(Model model) {

        List<Pair> pairs = pairService.getAllPairs();
        model.addAttribute("pairs", pairs);
        return "coffee/pairs";
    }

    @GetMapping("/create")
    public String createPairs(Model model) {
        List<Pair> pairs = pairService.createNewPairs(LocalDate.now());
        model.addAttribute("pairs", pairs);
        return "coffee/pairs";
    }

}
