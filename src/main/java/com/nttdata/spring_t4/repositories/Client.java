package com.nttdata.spring_t4.repositories;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Taller 3 Spring
 * 
 * Client Entity
 * 
 * @author Fernando Pérez Nieto
 *
 */
@Entity
@Table(name = "T_CLIENT")
public class Client implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Id (PK) */
	private Long clientId;

	/** Client name */
	private String name;

	/** Client surname */
	private String surname;
	
	/** Client birthdate */
	private Date birthdate;

	/** Client dni */
	private String dni;
	
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", name=" + name + ", surname=" + surname + ", birthdate=" + birthdate
				+ ", dni=" + dni + "]";
	}

	/**
	 * @return the clientId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "C_CLIENT_ID", nullable = false)
	public Long getClientId() {
		return clientId;
	}	
	
	/**
	 * @param clientId
	 * 			the client id to set
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the surname
	 */
	@Column(name = "C_SURNAME", nullable = false)
	public String getSurname() {
		return surname;
	}

	/**
	 * @param firstSurname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the dni
	 */
	@Column(name = "C_DNI", nullable = false)
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the name
	 */
	@Column(name = "C_NAME", nullable = false)
	public String getName() {
		return name;
	}
	
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the client birthdate
	 */
	@Column(name = "C_BIRTHDATE", nullable = false)
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Transient
	public Class<?> getClase() {
		return Client.class;
	}
}