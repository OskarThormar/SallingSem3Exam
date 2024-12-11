package salling.sallingsem3exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import salling.sallingsem3exam.model.Day;

public interface DayInterface  extends JpaRepository<Day, Integer> {
}
