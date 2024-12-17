package salling.sallingsem3exam.repository;

import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import salling.sallingsem3exam.model.Madplan;
        import salling.sallingsem3exam.model.Recipe;

import java.util.ArrayList;
        import java.util.List;

        import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    private Repository repository;

    @BeforeEach
    void setUp() {
        repository = new Repository();
    }

    @Test
    void testCreateMadplanWithCompleteRecipeList() {
        // Arrange
        Madplan madplan = new Madplan(1, new ArrayList<>(), "Complete Plan", 100.0);
        madplan.setRecipeListForMultipleDays(3); // 3-day plan

        Recipe morning = new Recipe("Morning Recipe", "morning");
        Recipe lunch = new Recipe("Lunch Recipe", "lunch");
        Recipe evening = new Recipe("Evening Recipe", "evening");

        repository.allRecipes.add(morning);
        repository.allRecipes.add(lunch);
        repository.allRecipes.add(evening);

        // Act
        repository.createMadplan(madplan);

        // Assert
        assertNotNull(madplan.getMealTimeList());
        assertEquals(morning, madplan.getMealTimeList()[0]);
        assertEquals(lunch, madplan.getMealTimeList()[1]);
        assertEquals(evening, madplan.getMealTimeList()[2]);
    }

    @Test
    void testCreateMadplanThrowsExceptionForMissingMealTime() {
        // Arrange
        Madplan madplan = new Madplan(1, new ArrayList<>(), "Incomplete Plan", 100.0);
        madplan.setRecipeListForMultipleDays(3); // 3-day plan

        Recipe morning = new Recipe("Morning Recipe", "morning");
        Recipe evening = new Recipe("Evening Recipe", "evening");

        repository.allRecipes.add(morning);
        repository.allRecipes.add(evening);

        // Act & Assert
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            repository.createMadplan(madplan);
        });

        assertTrue(exception.getMessage().contains("Missing recipe for lunch meal"));
    }

    @Test
    void testCreateMadplanAddsToRepository() {
        // Arrange
        Madplan madplan = new Madplan(1, new ArrayList<>(), "Test Plan", 100.0);
        madplan.setRecipeListForMultipleDays(3); // 3-day plan

        Recipe morning = new Recipe("Morning Recipe", "morning");
        Recipe lunch = new Recipe("Lunch Recipe", "lunch");
        Recipe evening = new Recipe("Evening Recipe", "evening");

        repository.allRecipes.add(morning);
        repository.allRecipes.add(lunch);
        repository.allRecipes.add(evening);

        // Act
        repository.createMadplan(madplan);

        // Assert
        assertTrue(repository.getMadplan().contains(madplan), "Madplan should be added to the repository");
    }

    @Test
    void testCreateMadplanWithMultipleDays() {
        // Arrange
        Madplan madplan = new Madplan(1, new ArrayList<>(), "Multi-Day Plan", 100.0);
        madplan.setRecipeListForMultipleDays(5); // 5-day plan

        Recipe morning = new Recipe("Morning Recipe", "morning");
        Recipe lunch = new Recipe("Lunch Recipe", "lunch");
        Recipe evening = new Recipe("Evening Recipe", "evening");

        repository.allRecipes.add(morning);
        repository.allRecipes.add(lunch);
        repository.allRecipes.add(evening);

        // Act
        repository.createMadplan(madplan);

        // Assert
        assertNotNull(madplan.getRecipeListForMultipleDays());
        assertEquals(5, madplan.getRecipeListForMultipleDays().length);

        for (List<Recipe> day : madplan.getRecipeListForMultipleDays()) {
            assertEquals(3, day.size());
            assertEquals(morning, day.get(0)); // Morning
            assertEquals(lunch, day.get(1));  // Lunch
            assertEquals(evening, day.get(2)); // Evening
        }
    }

    @Test
    void testGetMadplanContainsTestMadplan() {
        // Get the list of Madplans
        List<Madplan> madplans = repository.getMadplan();

        // Check if the list is not empty
        assertFalse(madplans.isEmpty(), "Madplan list should not be empty");

        // Check if there's a Madplan with the name "test"
        boolean containsTestMadplan = madplans.stream()
                .anyMatch(madplan -> "test".equals(madplan.getName()));

        assertTrue(containsTestMadplan, "Madplan list should contain a Madplan named 'test'");
    }
}
