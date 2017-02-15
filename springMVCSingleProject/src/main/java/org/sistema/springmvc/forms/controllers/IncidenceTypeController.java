package org.sistema.springmvc.forms.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.sistema.springmvc.forms.dao.GenericDAO;
import org.sistema.springmvc.forms.models.IncidenceType;
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
public class IncidenceTypeController {

	@Autowired
	private GenericDAO<IncidenceType> incidenceTypeDAO;

	/**
	 * handles /incidenceTypes/id
	 * 
	 * @param model
	 * @return the name of the view to show RequestMapping({"/incidences/{id}"})
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/incidenceTypes/{id}" })
	public String incidenceIncidenceTypeDetail(@PathVariable(value = "id") Integer id,
			Map<String, Object> model) {
		System.out.println("Incidence incidenceType detail");

		IncidenceType incidenceType = incidenceTypeDAO.selectById(id, IncidenceType.class);
		model.put("incidenceType", incidenceType);

		return "incidenceType/incidenceTypeDetail";
	}

	/**
	 * handles /incidences/incidenceType/new by POST
	 * 
	 * @return the name of the view to show RequestMapping({"/incidences/new"})
	 */
	@RequestMapping(method = RequestMethod.POST, value = { "/incidenceTypes/new" })
	public ModelAndView createIncidenceType(IncidenceType incidenceType) {
		
		ModelAndView modelAndView = new ModelAndView();

		incidenceTypeDAO.insert(incidenceType);
			// We return view name
			modelAndView.setViewName("incidenceType/created");
			modelAndView.addObject("incidenceType", incidenceType);
			System.out.println("Saveview POST " + incidenceType.getId());
		
		return modelAndView;
	}

	/**
	 * Simply selects the update view for incidenceTypes
	 */
	@RequestMapping(value = "/incidenceTypes/update/{id}", method = RequestMethod.GET)
	public String updateIncidenceType(@PathVariable(value = "id") Integer incidenceTypeId,
			Model model) {
		System.out.println("Showing update incidenceType view GET ");

		// We find the incidenceType through DAO and load into model
		model.addAttribute("incidenceType", incidenceTypeDAO.selectById(incidenceTypeId,IncidenceType.class));

		return "incidenceType/update";
	}

	/**
	 * Handles the POST from the Custom.jsp page to update the Incidence.
	 */
	@RequestMapping(value = "/incidenceTypes/saveupdate", method = RequestMethod.POST)
	public ModelAndView saveUpdateIncidenceType(@Valid IncidenceType incidenceType, BindingResult bindingResult) {
		System.out.println("Save update incidenceType " + incidenceType.getId());

		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.addObject("incidenceType", incidenceType);
			modelAndView.setViewName("incidenceType/saveUpdated");
			return modelAndView;
		}
		
		incidenceTypeDAO.update(incidenceType);
		
		// We pass the incidence received through this object
		modelAndView.addObject("incidenceType", incidenceType);

		// The same as return "incidence/saveUpdate"
		modelAndView.setViewName("incidenceType/saveUpdated");
		
		return modelAndView;
	}

	/**
	 * Delete the specific incidenceType
	 */
	@RequestMapping(value = "/incidenceTypes/delete/{id}", method = RequestMethod.GET)
	public String deleteIncidenceType(@PathVariable(value = "id") Integer incidenceTypeId,
			Model model) {
		System.out.println("Incidence detail /delete incidenceType: " + incidenceTypeId);

		// Store the concrete incidenceType to send it back before deleting to use it in
		// the following view.
		IncidenceType incidenceType = incidenceTypeDAO.selectById(incidenceTypeId, IncidenceType.class);
		model.addAttribute("incidenceType", incidenceType);

		incidenceTypeDAO.delete(incidenceType);

		return "incidenceType/deleted";
	}

}
