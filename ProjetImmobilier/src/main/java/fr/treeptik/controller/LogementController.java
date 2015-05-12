package fr.treeptik.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.exception.ControllerException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Commune;
import fr.treeptik.model.Logement;
import fr.treeptik.model.Quartier;
import fr.treeptik.model.SearchDTO;
import fr.treeptik.service.CommuneService;
import fr.treeptik.service.LogementService;
import fr.treeptik.service.QuartierService;

@Controller
//@RestController
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
	
	@ModelAttribute("prixMin")
	public Set<Double> populatePrixMin() {

		Set<Double> prixMinimum = new TreeSet<Double>();
		prixMinimum.add(300.00);
		prixMinimum.add(400.00);
		prixMinimum.add(500.00);
		prixMinimum.add(600.00);
		prixMinimum.add(700.00);
		prixMinimum.add(800.00);
		prixMinimum.add(900.00);
		prixMinimum.add(1000.00);
		prixMinimum.add(1100.00);
		prixMinimum.add(1200.00);
		return prixMinimum;

	}
	
	
	
//	@RequestMapping(value = "index.jsp", method = RequestMethod.GET)
//	@ResponseStatus(value = HttpStatus.OK)
	public List<Commune> getCommunesList() throws ControllerException {
		try {
			List<Commune> communes = communeService.findAll();
			return communes;

		} catch (ServiceException e) {
			throw new ControllerException(
					"Erreur dans LogementController de getCommunesList", e);
		}
	}
	
	@RequestMapping(value = "/commune.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Quartier> getQuartierList(@RequestParam("communeNom") String nomCommune) throws ControllerException{
		try {
			logger.debug("nom commune : " + nomCommune);
			return quartierService.findbyCommune(nomCommune);
		} catch (ServiceException e) {
			throw new ControllerException(
					"Erreur dans LogementController de getQuartierList", e);
		}
	}
	
	
	
	@RequestMapping(value = "/prix.do", method = RequestMethod.GET)
	@ResponseBody
	public Set<Double> populatePrixMax(@RequestParam("minimum") Double prixMinimum){
		logger.debug("prix minimum : " + prixMinimum);
		Set<Double> prixMax = new TreeSet<Double>();
		
		Integer iter = (int) (11-(prixMinimum/100));
		
		for(int i=iter; i>=0; i--){
			prixMinimum+=100.00;
			prixMax.add(prixMinimum);
		}
		
		return prixMax;
	}
	

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String initForm(Model model) throws ControllerException {
		
		this.getCommunesList();
//		this.getQuartierList(nomCommune);
		model.addAttribute("searchDTO", new SearchDTO());
		return "index.jsp";
	}


	@RequestMapping(value = "/index.do", method = RequestMethod.POST)
	public ModelAndView submitForm(SearchDTO searchDTO, BindingResult result) throws ServiceException {

		List<Logement> logements = null;
		
		Integer superficieMIN = null;
		Integer superficieMAX = null;
		Double loyerMIN = searchDTO.getPrixMin();
		Double loyerMAX = searchDTO.getPrixMax();
		String libelleQuartier = searchDTO.getQuartier();
		String nomCommune = searchDTO.getCommune();
		
		logger.debug("libelleQuartier : " + libelleQuartier + " nomCommune : " + nomCommune);
		logger.debug("loyerMIN : " + loyerMIN + " loyerMAX : " + loyerMAX);

		logements = logementService.multiSearchLogement(superficieMIN, superficieMAX, loyerMIN, loyerMAX, libelleQuartier, nomCommune);
			
//		logements = logementService.findByLoyer(300.00, 700.00);

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
