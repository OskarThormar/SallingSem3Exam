package salling.sallingsem3exam.repository;

import salling.sallingsem3exam.model.Madplan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import salling.sallingsem3exam.model.Recipe;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class MadplanRepositoryTest {

    private MadplanRepository madplanRepository;

    @BeforeEach
    void setUp() {
        madplanRepository = new MadplanRepository();
    }

    @Test
    void testGetMadplanContainsTestMadplan() {
        // Get the list of Madplans
        List<Madplan> madplans = madplanRepository.getMadplan();

        // Check if the list is not empty
        assertFalse(madplans.isEmpty(), "Madplan list should not be empty");

        // Check if there's a Madplan with the name "test"
        boolean containsTestMadplan = madplans.stream()
                .anyMatch(madplan -> "test".equals(madplan.getName()));

        assertTrue(containsTestMadplan, "Madplan list should contain a Madplan named 'test'");
    }

    @Test
    void testCreateMadplan_SetsRecipesCorrectly() {
        // Arrange
        Madplan madplan = new Madplan(1, new ArrayList<>(), "Test Meal Plan", 100.0);
        madplan.setDays(7);
        Recipe recipe1 = new Recipe("test1", "morning");
        Recipe recipe2 = new Recipe("test2", "frokost");
        Recipe recipe3 = new Recipe("test3", "aften");




        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe1);
        recipeList.add(recipe2);
        recipeList.add(recipe3);

        // Act
        madplanRepository.createMadplan(madplan);

        // Assert
        assertEquals(recipe1, madplan.getMealTimeList()[0]);
        assertEquals(recipe2, madplan.getMealTimeList()[1]);
        assertEquals(recipe3, madplan.getMealTimeList()[2]);
    }

    @Test
    void testCreateMadplan_SetsDaysCorrectly() {
        // Arrange
        Madplan madplan = new Madplan(1, new ArrayList<>(), "Test Meal Plan", 100.0);
        madplan.setDays(7);

        // Act
        madplanRepository.createMadplan(madplan);

        // Assert
        assertNotNull(madplan.getDays());
        assertEquals(7, madplan.getDays().length);
    }
}