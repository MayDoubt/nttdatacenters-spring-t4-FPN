package com.nttdata.spring_t4.services;

import java.util.List;

import com.nttdata.spring_t4.repositories.Client;

/**
 * Taller 3 Spring
 * 
 * Client Management Service Interface
 * 
 * @author Fernando Pérez Nieto
 *
 */
public interface ClientManagementServiceI {

	/**
	 * Insert new client
	 * 
	 * @param newClient
	 */
	public void insertNewClient(final Client newClient);

	/**
	 * Update client
	 * 
	 * @param updatedClient
	 */
	public void updateClient(final Client updatedClient);

	/**
	 * Delete a client
	 * 
	 * @param deletedClient
	 */
	public void deleteClient(final Client deletedClient);

	/**
	 * Get a client by id
	 * 
	 * @param clientId
	 */
	public Client searchById(final Long clientId);

	/**
	 * Get all the clients
	 * 
	 * @return List<Client>
	 */
	public List<Client> searchAll();
	
	/**
	 * Get a client by dni
	 * 
	 * @param dni
	 * @return List<Client>
	 */
	public List<Client> searchByDni(final String dni);
	
	/**
	 * Get a client by name and surname
	 * 
	 * @param name
	 * @param surname
	 * @return List<Client>
	 */
	public List<Client> searchByNameAndSurname(final String name, final String surname);
}
