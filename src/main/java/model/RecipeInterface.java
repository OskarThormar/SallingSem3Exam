package model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeInterface extends JpaRepository<Recipe, Integer> {
}
