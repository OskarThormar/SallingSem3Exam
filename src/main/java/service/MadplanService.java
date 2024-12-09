package service;

import model.Madplan;
import model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MadplanRepository;

import java.util.List;

@Service
public class MadplanService {
    private MadplanRepository madplanRepository;

    @Autowired
    private model.MadplanRepository madplanInterface;

    public MadplanService(MadplanRepository madplanRepository) {
        this.madplanRepository = madplanRepository;
    }

    public List<Recipe> getRecipesFromMadplan(int madplanId) {
        return madplanRepository.getRecipesForMadplan(madplanId);
    }

    public double calculateTotalPriceForMadplan(int madplanId) {
        return madplanRepository.calculateTotalPriceForMadplan(madplanId);
    }

    public List<Madplan> getAllMadplans() {
        return madplanInterface.findAll();
    }

    public Madplan createMadplan(Madplan madplan) {
        return madplanInterface.save(madplan);
    }

    public Madplan getMadplanById(int id) {
        return madplanInterface.findById(id).orElse(null);
    }

}
