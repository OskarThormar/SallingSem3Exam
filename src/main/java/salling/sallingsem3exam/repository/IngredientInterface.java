package salling.sallingsem3exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salling.sallingsem3exam.model.Ingredients;

@Repository
public interface IngredientInterface  extends JpaRepository<Ingredients, Integer> {
}
