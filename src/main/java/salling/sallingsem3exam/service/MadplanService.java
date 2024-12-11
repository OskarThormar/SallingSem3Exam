package salling.sallingsem3exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salling.sallingsem3exam.model.Recipe;
import salling.sallingsem3exam.repository.MadplanRepository;
import salling.sallingsem3exam.repository.MadplanRepositoryInterface;

import java.util.List;
@Service
public class MadplanService {
    private MadplanRepository madplanRepository;
    private MadplanRepositoryInterface madplanRepositoryInterface;
    public MadplanService(MadplanRepository madplanRepository) {
        this.madplanRepository = madplanRepository;
    }

    public List<Recipe> getRecipesFromMadplan(int madplanId) {
        return madplanRepository.getRecipesForMadplan(madplanId);
    }

    /*public double calculateTotalPriceForMadplan(int madplanId) {
        return madplanRepository.calculateTotalPriceForMadplan(madplanId);
    }*/
}
