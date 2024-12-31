package salling.sallingsem3exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salling.sallingsem3exam.model.Madplan;
@Repository
public interface MadplanInterface  extends JpaRepository<Madplan, Integer> {
}
