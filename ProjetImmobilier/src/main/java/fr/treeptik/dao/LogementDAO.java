package fr.treeptik.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.treeptik.model.Commune;
import fr.treeptik.model.Logement;
import fr.treeptik.model.Quartier;

public interface LogementDAO extends JpaRepository<Logement, Integer> {
	
	@Query("SELECT l FROM Logement l WHERE l.estDispo=1")
	List<Logement> findAllByEstDispo();
	
	@Query("SELECT l FROM Logement l JOIN l.quartier q WHERE q = :quartier")
	Set<Logement> findByQuartier(@Param("quartier") Quartier quartier);
	
	@Query("SELECT l "
			+ "FROM Logement l "
			+ "JOIN l.quartier q "
			+ "WHERE q.commune IN ( "
			+ "SELECT q.commune "
			+ "FROM Quartier q "
			+ "WHERE q.commune =:commune)")
	Set<Logement> findByCommune(@Param("commune") Commune commune);
	
	@Query("SELECT l "
			+ "FROM Logement l "
			+ "WHERE l.loyer BETWEEN :loyerMin AND :loyerMax")
	Set<Logement> findByLoyer(@Param("loyerMin") Double loyerMin, @Param("loyerMax") Double loyerMax);
	

	
//	@Query("SELECT p FROM Logement l JOIN l.proprietaire p")
//	Set<Individu> findAllProprietaire();
//	
//	@Query("SELECT q FROM Logement l JOIN l.quartier q")
//	Set<Quartier> findAllQuartier();
		

}
