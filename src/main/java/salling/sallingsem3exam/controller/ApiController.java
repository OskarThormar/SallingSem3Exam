package salling.sallingsem3exam.controller;

import org.springframework.web.bind.annotation.*;
import salling.sallingsem3exam.model.Day;
import salling.sallingsem3exam.model.Madplan;
import salling.sallingsem3exam.service.Service;

import java.util.List;

@RestController
public class ApiController {

    private Service service;
    public ApiController(Service service){
        this.service = service;
    }
    @GetMapping("/api/plan/foodPlan")
    public List<Madplan> parseMadplanToJson(){
        List<Madplan> madplan = service.getAllMadplans();
        return madplan;
    }

    @PostMapping("/api/plan/foodPlan")
    public Madplan createFoodplan(@RequestBody Madplan newMadplan){
        service.createMadPlan(newMadplan);
        return newMadplan;
    }

    @GetMapping("/api/plan/foodPlan/{ID}")
    public Madplan getMadPlanByID(@PathVariable int ID){
        Madplan madplanFound = service.getMadPlanByID(ID);
        return madplanFound;
    }

    @DeleteMapping("/api/plan/foodPlan/{ID}")
    public void deleteMadPlan(@PathVariable int ID){
        service.deleteMadPlan(ID);
    }

    @PutMapping("/api/plan/foodPlan/{ID}")
    public Madplan updateMadPlan(@PathVariable int ID, @RequestBody Madplan madplanToBeUpdated){
        service.updateMadplan(ID, madplanToBeUpdated);
        return madplanToBeUpdated;
    }

    @GetMapping("/api/plan/foodPlan/{ID}/days")
    public List<Day> showAmountOfDays(@PathVariable int ID){
        List<Day> listOfDays = service.getAllDaysFromMadplan(ID);
        return listOfDays;
    }
}
