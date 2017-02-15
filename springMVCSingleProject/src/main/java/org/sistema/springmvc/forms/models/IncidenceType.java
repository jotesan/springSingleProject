package org.sistema.springmvc.forms.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Represents a incidence type.
 * 
 * @author Joseba Teré
 *
 */
@Entity
public class IncidenceType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "The name must not be blank.")
	@Size(max = 50, message = "Can't have more than 50 letters")
	private String name;
	
	@NotEmpty(message = "The description must not be blank.")
	@Size(max = 100, message = "Can't have more than 100 letters")
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER, mappedBy="type")
	private Set<Incidence> incidences = new HashSet<Incidence>();

	/**
	 * default constructor
	 */
	public IncidenceType() {
	}

	/**
	 * constructor with parameters
	 * @param id
	 * @param name
	 * @param description
	 */
	public IncidenceType(int id, String name, String description, String password) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the incidences
	 */
	public Set<Incidence> getIncidences() {
		return incidences;
	}

	/**
	 * @param incidences the incidences to set
	 */
	public void setIncidences(Set<Incidence> incidences) {
		this.incidences = incidences;
	}

}
