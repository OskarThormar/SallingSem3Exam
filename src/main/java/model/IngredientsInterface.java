package model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsInterface extends JpaRepository<Ingredients, Integer> {
}
