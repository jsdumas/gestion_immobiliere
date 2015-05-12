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
	
	@Query("select l from Logement l "
			+ "left join l.proprietaire p "
			+ "left join l.typeLogement t "
			+ "left join l.quartier q "
			+ "left join q.commune c "
			+ "where :superficieMIN is null or :superficieMIN = '' or :superficieMAX is null or :superficieMAX = '' or l.superficie between :superficieMIN and :superficieMAX "
			+ "and :loyerMIN is null or :loyerMIN = '' or :loyerMAX is null or :loyerMAX = '' or l.loyer between :loyerMIN and :loyerMAX "
			+ "and :libelleQuartier is null or :libelleQuartier = '' or q.libelleQuartier = :libelleQuartier "
			+ "and :nomCommune is null or :nomCommune = '' or c.nomCommune = :nomCommune")
	List<Logement> multiSearch(
			@Param("superficieMIN") Integer superficieMIN,
			@Param("superficieMAX") Integer superficieMAX,
			@Param("loyerMIN") Double loyerMIN,
			@Param("loyerMAX") Double loyerMAX,
			@Param("libelleQuartier") String libelleQuartier,
			@Param("nomCommune") String nomCommune);
	

	
//	@Query("SELECT p FROM Logement l JOIN l.proprietaire p")
//	Set<Individu> findAllProprietaire();
//	
//	@Query("SELECT q FROM Logement l JOIN l.quartier q")
//	Set<Quartier> findAllQuartier();
		

}
