package salling.sallingsem3exam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
}