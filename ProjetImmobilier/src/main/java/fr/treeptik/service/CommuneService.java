package fr.treeptik.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.CommuneDAO;
import fr.treeptik.dao.QuartierDAO;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Commune;
import fr.treeptik.model.Logement;
import fr.treeptik.model.Quartier;

@Service
public class CommuneService {
	
	@Autowired
	private CommuneDAO communeDAO;
	
	public List<Commune> findAll() throws ServiceException {
		try {
			return communeDAO.findAll();
		} catch (DataAccessException e) {
			throw new ServiceException("erreur de CommuneService findAll", e);
		}
	}

}
