package salling.sallingsem3exam.repository;

import salling.sallingsem3exam.model.Madplan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}