package org.sistema.springmvc.forms.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.sistema.springmvc.forms.dao.GenericDAO;
import org.sistema.springmvc.forms.models.IncidenceType;
import org.sistema.springmvc.forms.models.Incidence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for incidences.
 * 
 * @author Eugenia Pérez Martínez
 *
 */
@Controller
public class IncidenceController {

	@Autowired
	private GenericDAO<Incidence> incidenceDAO;

	@Autowired
	private GenericDAO<IncidenceType> incidenceTypeDAO;

	/**
	 * handles default /incidences
	 * 
	 * @param model
	 * @return the name of the view to show RequestMapping({"/incidences"})
	 */

	@RequestMapping(method = RequestMethod.GET, value = { "/", "/incidences" })
	public String showIncidences(Map<String, Object> model) {
		System.out.println("Incidence showIncidences. ");

		List<Incidence> incidences = incidenceDAO.selectAll(Incidence.class);
		model.put("incidences", incidences);

		return "incidence/incidences";
	}

	/**
	 * handles default /incidences/id
	 * 
	 * @param model
	 * @return the name of the view to show RequestMapping({"/incidences/{id}"})
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/incidences/{id}" })
	public String incidenceDetail(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
		System.out.println("Incidence detail");

		Incidence incidence = incidenceDAO.selectById(id, Incidence.class);
		// The incidence gets his own collection of tasks load
		model.put("incidence", incidence);

		// We add task for the new task form
		IncidenceType type = new IncidenceType();
		type.getIncidences().add(incidence);
		model.put("type", type);

		return "incidence/incidenceDetail";
	}

	/**
	 * handles /incidences/new by GET
	 * 
	 * @return the name of the view to show RequestMapping({"/incidences/new"})
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/incidences/new" })
	public String newIncidence(Map<String, Object> model) {
		System.out.println("Showing custom view GET ");

		model.put("incidence", new Incidence());
		model.put("incidenceTypes", incidenceTypeDAO.selectAll(IncidenceType.class));

		return "incidence/newIncidence";
	}

	/**
	 * handles /incidences/new by POST
	 * 
	 * @return the name of the view to show RequestMapping({"/incidences/new"})
	 */
	@RequestMapping(method = RequestMethod.POST, value = { "/incidences/new" })
	public ModelAndView createIncidence(@Valid Incidence incidence, BindingResult bindingResult) {
		System.out.println("Saveview POST " + incidence.getId());

		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("incidence/created");
			modelAndView.addObject("incidence", incidence);
			return modelAndView;
		}

		incidenceDAO.insert(incidence);
		// We return view name
		modelAndView.setViewName("incidence/created");
		modelAndView.addObject("incidence", incidence);

		return modelAndView;
	}

	/**
	 * Simply selects the update view
	 */
	@RequestMapping(value = "/incidences/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable(value = "id") Integer incidenceId, Model model) {
		System.out.println("Showing update view GET ");

		// We find the incidence through DAO and load into model
		model.addAttribute("incidence", incidenceDAO.selectById(incidenceId, Incidence.class));
		model.addAttribute("incidenceTypes", incidenceTypeDAO.selectAll(IncidenceType.class));

		return "incidence/update";
	}

	/**
	 * Handles the POST from the Custom.jsp page to update the Incidence.
	 */
	@RequestMapping(value = "/incidences/saveupdate", method = RequestMethod.POST)
	public ModelAndView saveUpdate(@Valid Incidence incidence, BindingResult bindingResult) {
		System.out.println("Save update " + incidence.getId());

		ModelAndView modelAndView = new ModelAndView();
		
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("incidence", incidence);
			modelAndView.setViewName("incidence/saveUpdated");
			return modelAndView;
		}
		
		incidenceDAO.update(incidence);

		// We pass the incidence received through this object
		modelAndView.addObject("incidence", incidence);

		// The same as return "incidence/saveUpdate"
		modelAndView.setViewName("incidence/saveUpdated");
		
		return modelAndView;
	}

	/**
	 * Delete the specific incidence
	 */
	@RequestMapping(value = "/incidences/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable(value = "id") Integer incidenceId, Model model) {
		System.out.println("Incidence detail /delete");

		incidenceDAO.delete(incidenceDAO.selectById(incidenceId, Incidence.class));
		model.addAttribute("incidenceId", incidenceId);

		return "incidence/deleted";
	}

}
