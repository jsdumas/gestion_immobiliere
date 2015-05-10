package fr.treeptik.service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Individu;
import fr.treeptik.model.Logement;
import fr.treeptik.model.Quartier;
import fr.treeptik.model.TypeLogement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:testApplicationContext.xml")	
public class LogementServiceTest {
	
	@Autowired
	private LogementService logementService;
	@Autowired
	private IndividuService individuService;
	@Autowired
	private TypeLogementService typeLogementService;
	@Autowired
	private QuartierService quartierService;
	
	@Test
	public void shouldFindAll(){
		try {
			List<Logement> logements = logementService.findAll();
			for (Logement logement : logements) {
				System.out.println(logement + "\n");
			}
			
		} catch (ServiceException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void shouldFindAllByEstDispo(){
		try {
			List<Logement> logements = logementService.findAllByEstDispo();
			for (Logement logement : logements) {
				System.out.println(logement + "\n");
			}
		} catch (ServiceException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void shoudSave(){
		
		try {
			Logement logement = logementService.findOne(1);
			Individu proprietaire = individuService.findOne(6);
			TypeLogement typeLogement = typeLogementService.findOne(3);
			Quartier quartier = quartierService.findOne(6);
			
			Set<Date> dateAnnonces = new TreeSet<Date>();
			logement.setNumeroRue("24");
			logement.setNomRue("rue Alphonse Daudet");
			logement.setSuperficie("1000 m2");
			logement.setEstDispo(true);
			logement.setLoyer(1500.00);
			logement.setTypeLogement(typeLogement);
			logement.setQuartier(quartier);
			logement.setProprietaire(proprietaire);
			dateAnnonces.add(new Date(2015-05-04));
			logement.setDatesAnnonce(dateAnnonces);
			logement.setSuperficie("300 m2");
			
			logementService.save(logement);
			
		} catch (ServiceException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void shouldDelete(){
		try {
			Logement logement = logementService.delete(1);
			
		} catch (ServiceException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void findByQuartier(){
		try {
			Quartier quartier = quartierService.findOne(1);
			Set<Logement> logements = logementService.findByQuartier(quartier);
			for (Logement logement : logements) {
				System.out.println("********************************");
				System.out.println("Find by quartier : " + logement);
			}
		} catch (ServiceException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void findByLoyer(){
		try {
			Set<Logement> logements = logementService.findByLoyer(200.00, 600.00);
			for (Logement logement : logements) {
				System.out.println("********************************");
				System.out.println("Find by Loyer : " + logement);
			}
		} catch (ServiceException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
}
