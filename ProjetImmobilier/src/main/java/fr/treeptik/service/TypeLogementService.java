package fr.treeptik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.TypeLogementDAO;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Individu;
import fr.treeptik.model.TypeLogement;

@Service
public class TypeLogementService {
	
	@Autowired
	private TypeLogementDAO typeLogementDAO;
	
	public List<TypeLogement> findAll() throws ServiceException {
		try {
			return typeLogementDAO.findAll();
		} catch (DataAccessException e) {
			throw new ServiceException("erreur de TypeLogementService findAll", e);
		}
	}
	
	public TypeLogement findOne(Integer id) throws ServiceException{
		try {
			return typeLogementDAO.findOne(id);
		} catch (DataAccessException e) {
			throw new ServiceException("erreur de TypeLogementService findOne", e);
		}
	} 

}
