package fr.treeptik.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.QuartierDAO;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Commune;
import fr.treeptik.model.Quartier;

@Service
public class QuartierService {
	
	@Autowired
	private QuartierDAO quartierDAO;
	
	public List<Quartier> findAll() throws ServiceException {
		try {
			return quartierDAO.findAll();
		} catch (DataAccessException e) {
			throw new ServiceException("erreur de QuartierService findAll", e);
		}
	}
	
	public Quartier findOne(Integer id) throws ServiceException{
		try {
			return quartierDAO.findOne(id);
		} catch (DataAccessException e) {
			throw new ServiceException("erreur de QuartierService findOne", e);
		}
	}
	
	public List<Quartier> findbyCommune(String nomCommune) throws ServiceException{
		try {
			return quartierDAO.findByCommmune(nomCommune);
		} catch (DataAccessException e) {
			throw new ServiceException("erreur de QuartierService findbyCommune", e);
		}
		
	}
	
	@Transactional
	public Quartier delete(Integer id) throws ServiceException {
		try {
			Quartier quartier = quartierDAO.findOne(id);
			quartierDAO.delete(id);
			return quartier;
		} catch (DataAccessException e) {
			throw new ServiceException("erreur de QuartierService delete", e);
		}
	}

}
