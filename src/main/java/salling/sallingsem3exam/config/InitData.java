package salling.sallingsem3exam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import salling.sallingsem3exam.model.Ingredients;
import salling.sallingsem3exam.model.Madplan;
import salling.sallingsem3exam.model.Recipe;
import salling.sallingsem3exam.repository.MadplanRepositoryInterface;
import salling.sallingsem3exam.repository.RecipeRepositoryInterface;
import salling.sallingsem3exam.repository.IngredientsRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private MadplanRepositoryInterface madplanRepository;

    @Autowired
    private RecipeRepositoryInterface recipeRepository;

    @Autowired
    private IngredientsRepositoryInterface ingredientsRepository;

    @Override
    public void run(String... args) throws Exception {

        // Ingredients creation
        Ingredients ing1 = new Ingredients("Tomato", 1.5, "kg", 2);
        Ingredients ing2 = new Ingredients("Cheese", 3.0, "kg", 1);
        Ingredients ing3 = new Ingredients("Bread", 2.0, "loaf", 1);
        Ingredients ing4 = new Ingredients("Lettuce", 1.0, "head", 1);

        ingredientsRepository.save(ing1);
        ingredientsRepository.save(ing2);
        ingredientsRepository.save(ing3);
        ingredientsRepository.save(ing4);

        // Recipe creation
        List<Ingredients> recipe1Ingredients = new ArrayList<>();
        recipe1Ingredients.add(ing1);
        recipe1Ingredients.add(ing2);

        Recipe recipe1 = new Recipe("Cheese Sandwich", recipe1Ingredients, 5.5);

        List<Ingredients> recipe2Ingredients = new ArrayList<>();
        recipe2Ingredients.add(ing3);
        recipe2Ingredients.add(ing4);

        Recipe recipe2 = new Recipe("Veggie Sandwich", recipe2Ingredients, 4.0);

        recipeRepository.save(recipe1);
        recipeRepository.save(recipe2);

        // Madplan creation
        Madplan m1 = new Madplan();
        m1.setRecipeList(new ArrayList<>());
        m1.setName("Simple Meal Plan");
        m1.setPrice(15.0);
        m1.setAmountOfDays(7);

        // Adding recipes to Madplan
        m1.getRecipeList().add(recipe1);
        m1.getRecipeList().add(recipe2);

        madplanRepository.save(m1);

        // Additional Madplan for demonstration
        Madplan m2 = new Madplan();
        m2.setRecipeList(new ArrayList<>());
        m2.setName("Advanced Meal Plan");
        m2.setPrice(30.0);
        m2.setAmountOfDays(7);

        // Adding recipes to Madplan
        m2.getRecipeList().add(recipe1); // Cheese Sandwich
        m2.getRecipeList().add(recipe2); // Veggie Sandwich

        madplanRepository.save(m2);

        System.out.println("Sample data initialized");
    }
}
