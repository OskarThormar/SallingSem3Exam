package salling.sallingsem3exam.controller;

import org.springframework.web.bind.annotation.*;
import salling.sallingsem3exam.model.Madplan;
import salling.sallingsem3exam.repository.MadplanRepository;
import salling.sallingsem3exam.service.RecipeService;

import java.util.List;

@RestController
public class ApiController {

    private RecipeService recipeService;
    public ApiController(RecipeService recipeService){
        this.recipeService = recipeService;
    }
    @GetMapping("/api/plan/foodPlan")
    public List<Madplan> parseMadplanToJson(){
        List<Madplan> madplan = recipeService.getAllMadplans();
        return madplan;
    }

    @PostMapping("/api/plan/foodPlan")
    public Madplan createFoodplan(@RequestBody Madplan newMadplan){
        recipeService.createMadPlan(newMadplan);
        return newMadplan;
    }

    @GetMapping("/api/plan/foodPlan/{ID}")
    public Madplan getMadPlanByID(@PathVariable int ID){
        Madplan madplanFound = recipeService.getMadPlanByID(ID);
        return madplanFound;
    }

    @DeleteMapping("/api/plan/foodPlan/{ID}")
    public void deleteMadPlan(@PathVariable int ID){

    }
}
