package fr.treeptik.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.exception.ControllerException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Commune;
import fr.treeptik.model.Logement;
import fr.treeptik.model.Quartier;
import fr.treeptik.model.SearchModel;
import fr.treeptik.service.CommuneService;
import fr.treeptik.service.LogementService;
import fr.treeptik.service.QuartierService;


@Scope("request")
@Controller
@RequestMapping("/")
// @SessionAttributes("logement")
public class LogementController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Logger logger = Logger.getLogger(LogementController.class);

	@Autowired
	private LogementService logementService;
	@Autowired
	private CommuneService communeService;
	@Autowired
	private QuartierService quartierService;

	@ModelAttribute("allCommunes")
	public List<Commune> populateCommunes() throws ControllerException {

		try {
			List<Commune> communes = communeService.findAll();
			return communes;

		} catch (ServiceException e) {
			throw new ControllerException(
					"Erreur dans LogementController de listLogement", e);
		}

	}

	

	@ModelAttribute("allQuartiers")
	public List<Quartier> populateQuartiers() throws ControllerException {

		try {
			List<Quartier> quartiers = quartierService.findAll();
			return quartiers;

		} catch (ServiceException e) {
			throw new ControllerException(
					"Erreur dans LogementController de listLogement", e);
		}

	}
	
//	@RequestMapping(value = "index.jsp", method = RequestMethod.GET)
//	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody List<Commune> getCommunesList() throws ControllerException {
		try {
			List<Commune> communes = communeService.findAll();
			return communes;

		} catch (ServiceException e) {
			throw new ControllerException(
					"Erreur dans LogementController de getCommunesList", e);
		}
	}
	
	@RequestMapping(value = "/index.do/commune", method = RequestMethod.GET)
	@ResponseBody
	public List<Quartier> getQuartierList(@RequestParam(value = "nom_commune", required = true) String nomCommune) throws ControllerException{
		try {
			logger.debug("nom commune : " + nomCommune);
			return quartierService.findbyCommune(nomCommune);
		} catch (ServiceException e) {
			throw new ControllerException(
					"Erreur dans LogementController de getQuartierList", e);
		}
	}
	

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String initForm(Model model) throws ControllerException {
		
		this.getCommunesList();
		model.addAttribute("searchModel", new SearchModel());
		return "index.jsp";
	}
	
	
	

	@RequestMapping(value = "/index.do", method = RequestMethod.POST)
	public ModelAndView submitForm(SearchModel searchModel, BindingResult result) {

		Set<Logement> logements = null;

		if (!searchModel.getCommune().trim().isEmpty()
				&& searchModel.getQuartier().trim().isEmpty()) {
			logements = logementService
					.searchLogement(searchModel.getCommune());
		} else {
			logements = logementService.searchLogement(
					searchModel.getCommune(), searchModel.getQuartier());
		}

		// if(result.hasErrors()){
		// return "index.jsp";
		// } else {
		return new ModelAndView("logement/list.jsp", "logements", logements);
		// }
	}

	// @RequestMapping("/logement/list.do")
	// public ModelAndView listLogement() throws ControllerException {
	// try {
	// return new ModelAndView("list.jsp", "logements",
	// logementService.findAll());
	// } catch (ServiceException e) {
	// throw new ControllerException
	// ("Erreur dans LogementController de listLogement", e);
	// }
	// }

}
