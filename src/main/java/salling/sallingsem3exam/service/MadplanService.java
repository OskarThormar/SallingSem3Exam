package salling.sallingsem3exam.service;

import salling.sallingsem3exam.model.Recipe;
import salling.sallingsem3exam.repository.MadplanRepository;

import java.util.List;

public class MadplanService {
    private MadplanRepository madplanRepository;

    public MadplanService(MadplanRepository madplanRepository) {
        this.madplanRepository = madplanRepository;
    }

    public List<Recipe> getRecipesFromMadplan(int madplanId) {
        return madplanRepository.getRecipesForMadplan(madplanId);
    }

    public double calculateTotalPriceForMadplan(int madplanId) {
        return madplanRepository.calculateTotalPriceForMadplan(madplanId);
    }
}
