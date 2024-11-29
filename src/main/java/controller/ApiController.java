package controller;

import model.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.MadplanService;

import java.util.List;

@RestController
public class ApiController {
    private final MadplanService madplanService;

    public ApiController(MadplanService madplanService) {
        this.madplanService = madplanService;
    }

    @GetMapping("/madplan/{id}/recipes")
    public List<Recipe> getRecipesForMadplan(@PathVariable int id) {
        return madplanService.getRecipesFromMadplan(id);
    }

    @GetMapping("/madplan/{id}/price")
    public double getTotalPriceForMadplan(@PathVariable int id) {
        return madplanService.calculateTotalPriceForMadplan(id);
    }
}
