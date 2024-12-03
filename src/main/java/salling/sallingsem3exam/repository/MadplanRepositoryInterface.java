package salling.sallingsem3exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import salling.sallingsem3exam.model.Madplan;
import salling.sallingsem3exam.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public interface MadplanRepositoryInterface extends JpaRepository<Madplan, Integer> {

}
