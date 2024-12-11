package salling.sallingsem3exam.controller;  // Change the package

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
    @GetMapping("/foodplan")
    public String homePage(){
        return "homePage";
    }

    @GetMapping("/showFoodplans")
    public String showFoodPlans(){
        return "showFoodPlans";
    }

    @GetMapping("/createFoodplan")
    public String createFoodplan(){
        return "createFoodPlan";
    }
}