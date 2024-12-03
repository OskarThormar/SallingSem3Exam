/*
package salling.sallingsem3exam.controller;

import salling.sallingsem3exam.model.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import salling.sallingsem3exam.service.MadplanService;
import salling.sallingsem3exam.service.RecipeService;

import java.util.List;

@Controller
public class ApiController {

  private final MadplanService madplanService;
  private final RecipeService recipeService;

    public ApiController(MadplanService madplanService, RecipeService recipeService) {
        this.madplanService = madplanService;
        this.recipeService = recipeService;
    }

    @GetMapping("/madplan/{id}/recipes")
    public List<Recipe> getRecipesForMadplan(@PathVariable int id) {
        return madplanService.getRecipesFromMadplan(id);
    }

    @GetMapping("/madplan/{id}/price")
    public double getTotalPriceForMadplan(@PathVariable int id) {
        return madplanService.calculateTotalPriceForMadplan(id);
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
*/
