package salling.sallingsem3exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salling.sallingsem3exam.model.Day;
@Repository
public interface DayInterface  extends JpaRepository<Day, Integer> {
}
