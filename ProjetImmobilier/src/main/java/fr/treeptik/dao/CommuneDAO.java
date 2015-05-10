package fr.treeptik.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.treeptik.model.Commune;

public interface CommuneDAO extends JpaRepository<Commune, Integer> {
	
	@Query("SELECT c FROM Commune c WHERE c.nomCommune = :nomCommune")
	Commune findByNomCommune(@Param("nomCommune") String nomCommune);

}
