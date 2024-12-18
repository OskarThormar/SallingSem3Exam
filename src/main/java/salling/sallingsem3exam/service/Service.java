package salling.sallingsem3exam.service;

import salling.sallingsem3exam.model.Day;
import salling.sallingsem3exam.model.Madplan;
import salling.sallingsem3exam.model.Recipe;
import salling.sallingsem3exam.repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@org.springframework.stereotype.Service
public class Service {
    private List<Recipe> allRecipes = new ArrayList<>();

    private List<Recipe> morningRecipes = new ArrayList<>();
    private List<Recipe> lunchRecipes = new ArrayList<>();
    private List<Recipe> dinnerRecipes = new ArrayList<>();

    private List<Madplan> allMadplans = new ArrayList<>();
    private Repository repository;

    public Service(Repository repository){
        this.repository = repository;
    }

    public void createMadPlan(Madplan newMadplan){
        allRecipes = repository.getAllRecipes();

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

        int dayName = 1;
        for(int i = 0 ; i < newMadplan.getDay() ; i++){
            Day day = new Day();
            day.setName("day " + dayName);
            dayName++;

            day.setMadplan(newMadplan);
            newMadplan.getDays().add(day);
        }

        double priceForDay = 0;

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

            priceForDay = day.getMorningRecipe().getPrice() + day.getLunchRecipe().getPrice() + day.getEveningRecipe().getPrice();

            day.setFullPriceForDay(Math.round(priceForDay));
        }

        double madPlanPrice = 0;

        for(Day day : newMadplan.getDays()){
            madPlanPrice += day.getLunchRecipe().getPrice() + day.getMorningRecipe().getPrice() + day.getEveningRecipe().getPrice();
        }

        newMadplan.setPrice(Math.round(madPlanPrice));

        allMadplans.add(newMadplan);
        repository.saveMadplan(newMadplan);
        repository.saveMadPlanDays(newMadplan);
    }

    public Madplan getMadPlanByID(int ID){
        Madplan madplanFound = null;

        for(Madplan madplan : allMadplans){
            if(madplan.getId() == ID){
                madplanFound = madplan;
                break;
            }
        }

        return madplanFound;
    }

    public void deleteMadPlan(int ID){
        Madplan madplanToBeDeleted = null;

        for(Madplan madplan : allMadplans){
            if(madplan.getId() == ID){
                madplanToBeDeleted = madplan;
            }
        }

        if(!madplanToBeDeleted.equals(null)){
            allMadplans.remove(madplanToBeDeleted);
            repository.removeMadplan(madplanToBeDeleted);
        }
    }

    public void updateMadplan(int ID, Madplan updatedMadplan){
        Madplan madplan = repository.findMadPlanToUpdate(ID);

        if(madplan != null){
            madplan.setName(updatedMadplan.getName());
            // Add functionality to also update amount of days
            repository.saveMadplan(madplan);
        }
    }

    public List<Day> getAllDaysFromMadplan(int ID){
        List<Day> listOfDays = new ArrayList<>();

        for(Madplan madplan : allMadplans){
            if(madplan.getId() == ID){
                listOfDays = madplan.getDays();
            }
        }

        return listOfDays;
    }

    public List<Madplan> getAllMadplans(){
        return allMadplans;
    }
}
