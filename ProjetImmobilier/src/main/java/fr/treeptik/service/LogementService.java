package fr.treeptik.service;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.CommuneDAO;
import fr.treeptik.dao.LogementDAO;
import fr.treeptik.dao.QuartierDAO;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Commune;
import fr.treeptik.model.Logement;
import fr.treeptik.model.Quartier;

@Service
public class LogementService {

	private Logger logger = Logger.getLogger(LogementService.class);

	@Autowired
	private LogementDAO logementDAO;
	@Autowired
	private CommuneDAO communeDAO;
	@Autowired
	private QuartierDAO quartierDAO;

	public List<Logement> findAll() throws ServiceException {
		try {
			return logementDAO.findAll();
		} catch (DataAccessException e) {
			throw new ServiceException("erreur de LogementService findAll", e);
		}
	}

	public List<Logement> findAllByEstDispo() throws ServiceException {
		try {
			return logementDAO.findAllByEstDispo();
		} catch (DataAccessException e) {
			throw new ServiceException(
					"erreur de LogementService findAllByEstDispo", e);
		}
	}

	@Transactional
	public Logement save(Logement logement) throws ServiceException {
		try {
			return logementDAO.save(logement);
		} catch (DataAccessException e) {
			throw new ServiceException("erreur de LogementService save", e);
		}
	}

	public Logement findOne(Integer id) throws ServiceException {
		try {
			return logementDAO.findOne(id);
		} catch (DataAccessException e) {
			throw new ServiceException("erreur de LogementService findOne", e);
		}
	}

	@Transactional
	public Logement delete(Integer id) throws ServiceException {
		try {
			logementDAO.delete(id);
			return logementDAO.findOne(id);
		} catch (DataAccessException e) {
			throw new ServiceException("erreur de LogementService delete", e);
		}
	}

	public Set<Logement> findByQuartier(Quartier quartier)
			throws ServiceException {
		try {
			return logementDAO.findByQuartier(quartier);
		} catch (DataAccessException e) {
			throw new ServiceException(
					"erreur de LogementService findByQuartier", e);
		}
	}

	public List<Logement> findByLoyer(Double loyerMin, Double loyerMax)
			throws ServiceException {
		try {
			return logementDAO.findByLoyer(loyerMin, loyerMax);
		} catch (DataAccessException e) {
			throw new ServiceException("erreur de LogementService findByLoyer",
					e);
		}
	}


//	public Set<Logement> searchLogement(String commune, String libelleQuartier) {
//
//		Set<Logement> logementsByCommune = this.searchLogement(commune);
//		Set<Logement> logements = this.searchLogement(commune);
//
//		for (Logement logement : logementsByCommune) {
//			logger.info("Logement before if : getQuartier "
//					+ logement.getQuartier().getLibelleQuartier()
//					+ " libelleQuartier : " + libelleQuartier);
//			if (logement.getQuartier().getLibelleQuartier()
//					.equals(libelleQuartier)) {
//				logger.info("Logement during if : "
//						+ logement.getQuartier().getLibelleQuartier());
//				logements.remove(logement);
//			}
//		}
//
//		return logements;
//	}

	public List<Logement> multiSearchLogement(Integer superficieMIN,Integer superficieMAX,
											Double loyerMIN, Double loyerMAX,
											String libelleQuartier, String nomCommune) {
		return logementDAO.multiSearch(superficieMIN, superficieMAX, loyerMIN, loyerMAX, libelleQuartier, nomCommune);
	}
	


}
