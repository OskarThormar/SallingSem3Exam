package controller;

import model.Madplan;
import model.Recipe;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.MadplanRepository;

import java.util.List;

@RestController
public class ApiController {
    MadplanRepository MPR = new MadplanRepository()
    @GetMapping("")
    public String parseMadplanToJson(){
        List<Madplan> madplan =
        return "viewMadplan";
    }
}
