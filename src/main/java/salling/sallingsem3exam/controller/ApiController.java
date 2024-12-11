package salling.sallingsem3exam.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import salling.sallingsem3exam.model.Madplan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import salling.sallingsem3exam.repository.MadplanRepository;

import java.util.List;

@RestController
public class ApiController {
    MadplanRepository MPR = new MadplanRepository();
    @GetMapping("/api/plan/foodPlan")
    public List<Madplan> parseMadplanToJson(){
        List<Madplan> madplan = MPR.getMadplan();
        return madplan;
    }

//    @PostMapping("/api/plan/foodPlan")
//    public Madplan createFoodplan(@RequestBody Madplan newMadplan){
//        MPR.createMadplan(newMadplan);
//        return newMadplan;
//    }
}
