package fr.treeptik.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.treeptik.model.TypeLogement;

public interface TypeLogementDAO extends JpaRepository<TypeLogement, Integer> {

}
