package salling.sallingsem3exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import salling.sallingsem3exam.model.Madplan;
import salling.sallingsem3exam.model.Recipe;

public interface RecipeRepositoryInterface extends JpaRepository<Recipe, Integer> {

}
