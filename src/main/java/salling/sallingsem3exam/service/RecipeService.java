package salling.sallingsem3exam.service;

import org.springframework.stereotype.Service;
import salling.sallingsem3exam.model.Day;
import salling.sallingsem3exam.model.Madplan;
import salling.sallingsem3exam.model.Recipe;
import salling.sallingsem3exam.repository.MadplanRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RecipeService {
    private List<Recipe> allRecipes = new ArrayList<>();

    private List<Recipe> morningRecipes = new ArrayList<>();
    private List<Recipe> lunchRecipes = new ArrayList<>();
    private List<Recipe> dinnerRecipes = new ArrayList<>();

    private List<Madplan> allMadplans = new ArrayList<>();
    private MadplanRepository madplanRepository;

    public RecipeService(MadplanRepository madplanRepository){
        this.madplanRepository = madplanRepository;
    }

    public void createMadPlan(Madplan newMadplan){
        allRecipes = madplanRepository.getAllRecipes();

        Madplan madplan = newMadplan;

        for(Recipe recipe : allRecipes){
            if(recipe.getMealTime().equalsIgnoreCase("morning")){
                morningRecipes.add(recipe);
            }
            if(recipe.getMealTime().equalsIgnoreCase("lunch")){
                lunchRecipes.add(recipe);
            }
            if(recipe.getMealTime().equalsIgnoreCase("dinner")){
                dinnerRecipes.add(recipe);
            }
        }

        int dayName = 0;
        for(int i = 0 ; i < newMadplan.getDay() ; i++){
            Day day = new Day();
            day.setName("day" + dayName);
            dayName++;

            day.setMadplan(newMadplan);
            newMadplan.getDays().add(day);
        }


        for (Day day : madplan.getDays()) {
            Random random = new Random();

            if (day.getMorningRecipe() == null && !morningRecipes.isEmpty()) {
                int randomRecipe = random.nextInt(morningRecipes.size());
                day.setMorningRecipe(morningRecipes.get(randomRecipe));
            }
            if (day.getEveningRecipe() == null && !dinnerRecipes.isEmpty()) {
                int randomRecipe = random.nextInt(dinnerRecipes.size());
                day.setEveningRecipe(dinnerRecipes.get(randomRecipe));
            }
            if (day.getLunchRecipe() == null && !lunchRecipes.isEmpty()) {
                int randomRecipe = random.nextInt(lunchRecipes.size());
                day.setLunchRecipe(lunchRecipes.get(randomRecipe));
            }
        }

        double madPlanPrice = 0;

        for(Day day : newMadplan.getDays()){
            madPlanPrice += day.getLunchRecipe().getPrice() + day.getMorningRecipe().getPrice() + day.getEveningRecipe().getPrice();
        }

        newMadplan.setPrice(madPlanPrice);

        allMadplans.add(newMadplan);
        madplanRepository.saveMadplan(newMadplan);
        madplanRepository.saveMadPlanDays(newMadplan);
    }

    public Madplan getMadPlanByID(int ID){
        Madplan madplanFound = null;

        for(Madplan madplan : allMadplans){
            if(madplan.getId() == ID){
                madplanFound = madplan;
            }
        }

        return madplanFound;
    }

    public List<Madplan> getAllMadplans(){
        return allMadplans;
    }
}
