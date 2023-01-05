package com.nttdata.spring_t4.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nttdata.spring_t4.repositories.Client;
import com.nttdata.spring_t4.repositories.ClientRepositoryI;
import com.nttdata.spring_t4.utilities.InterfaceUtils;

/**
 * Taller 3 Spring
 * 
 * Client Management Service Implementation
 * 
 * @author Fernando Pérez Nieto
 *
 */
@Service
public class ClientManagementServiceImpl implements ClientManagementServiceI {

	/** Logger */
	private static Logger log = LoggerFactory.getLogger(ClientManagementServiceImpl.class);
	
	/** Client repository */
	@Autowired
	private ClientRepositoryI clientRepo;

	/**
	 * Method to insert a client
	 */
	@Override
	public void insertNewClient(final Client newClient) {
		log.trace(InterfaceUtils.INIT);
		
		// Verify if it's null or even exists
		if (newClient != null && newClient.getClientId() == null) {
			clientRepo.save(newClient);
		}
		log.trace(InterfaceUtils.END);
	}
	
	/**
	 * Method to update a client
	 */
	@Override
	public void updateClient(final Client updatedClient) {
		log.trace(InterfaceUtils.INIT);
		
		// Verify if it's null or even exists
		if (updatedClient != null && updatedClient.getClientId() != null) {
			clientRepo.save(updatedClient);
		}
		log.trace(InterfaceUtils.END);
	}
	
	/**
	 * Method to delete a client
	 */
	@Override
	public void deleteClient(final Client deletedClient) {
		log.trace(InterfaceUtils.INIT);
		
		// Verify if it's null or even exists
		if (deletedClient != null && deletedClient.getClientId() != null) {
			clientRepo.delete(deletedClient);
		}
		log.trace(InterfaceUtils.END);
	}
	
	/**
	 * Method to find a client by id
	 */
	@Override
	public Client searchById(final Long clientId) {
		log.trace(InterfaceUtils.INIT);
		
		// Result
		Client client = null;

		// Verify if it's null
		if (clientId != null) {
			client = clientRepo.findById(clientId).orElse(null);
		} else {
			System.out.println("There's not result with that id");
		}
		log.trace(InterfaceUtils.END);
		
		return client;
	}

	/**
	 * Method to find all client 
	 */
	@Override
	public List<Client> searchAll() {
		return clientRepo.findAll();
	}
	
	/**
	 * Method to find a client by name and surname
	 */
	@Override
	public List<Client> searchByDni(final String dni) {
		log.trace(InterfaceUtils.INIT);
		
		// Result
		List<Client> clientsList = new ArrayList<>();

		// Verify if it's null
		if (StringUtils.hasText(dni)) {
			clientsList = clientRepo.findByDni(dni);
		} else {
			System.out.println("There's not result with that dni");
		}
		log.trace(InterfaceUtils.END);
		return clientsList;
	}
	
	/**
	 * Method to find a client by name and surname
	 */
	@Override
	public List<Client> searchByNameAndSurname(String name, String surname) {
		return clientRepo.findByNameAndSurname(name, surname);
	}

}