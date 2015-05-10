package fr.treeptik.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.treeptik.model.Individu;

public interface IndividuDAO extends JpaRepository<Individu, Integer> {

}
