package org.sistema.springmvc.forms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Represents a incidence.
 * 
 * @author Joseba Teré
 *
 */
@Entity
public class Incidence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "The name must not be blank.")
	@Size(max = 50, message = "The name can't have more than 50 characters")
	private String name;
	
	@NotEmpty(message = "The description must not be blank.")
	@Size(max = 100, message = "The description Can't have more than 100 characters")
	private String description;
	
	@NotEmpty(message = "The date must not be blank.")
	private String date;
	
	@ManyToOne
    @JoinColumn(name="type")
	private IncidenceType type;
	
	/**
	 * default constructor
	 */
	public Incidence () {
		
	}
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param type
	 */
	public Incidence(int id, String name, String description, String date, IncidenceType type) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * @return the type
	 */
	public IncidenceType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(IncidenceType type) {
		this.type = type;
	}

	

}
