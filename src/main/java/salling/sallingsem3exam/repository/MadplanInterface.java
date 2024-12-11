package salling.sallingsem3exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import salling.sallingsem3exam.model.Madplan;
public interface MadplanInterface  extends JpaRepository<Madplan, Integer> {
}
