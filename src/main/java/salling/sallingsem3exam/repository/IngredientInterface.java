package salling.sallingsem3exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import salling.sallingsem3exam.model.Ingredients;

public interface IngredientInterface  extends JpaRepository<Ingredients, Integer> {
}
