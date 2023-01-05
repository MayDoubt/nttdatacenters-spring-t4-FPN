package com.nttdata.spring_t4.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.spring_t4.utilities.InterfaceUtils;
import com.nttdata.spring_t4.repositories.Client;
import com.nttdata.spring_t4.services.ClientManagementServiceI;

/**
 * Taller 4 Spring
 * 
 * Controller class
 * 
 * @author Fernando Pérez Nieto
 *
 */
@Controller
@RequestMapping("/springMVC")
public class ControllerMVC {
	
	/** Logger */
	private static Logger log = LoggerFactory.getLogger(ControllerMVC.class);
	
	
	@Autowired
	private ClientManagementServiceI clientService;

	@GetMapping("/")
	public String index() {
		log.trace(InterfaceUtils.INIT);
		log.trace(InterfaceUtils.END);
		return "index";
	}
	
	@GetMapping("/show-clients")
	public String listClients(Model model) {
		log.trace(InterfaceUtils.INIT);
		
		List<Client> clients = clientService.searchAll();
		model.addAttribute("clients", clients);
		
		log.trace(InterfaceUtils.END);
		return "client-list.html";
	}
	
	@GetMapping("/client-deleted{id}")
	public String deleted(@PathVariable(name = "id") Long id, Model model) {
		log.trace(InterfaceUtils.INIT);
		
		clientService.deleteClient(clientService.searchById(id));
		List<Client> clients = clientService.searchAll();
		model.addAttribute("clients", clients);
		
		log.trace(InterfaceUtils.END);
		return "client-list.html";		
	}
	
	@GetMapping("/register")
	public String register() {
		log.trace(InterfaceUtils.INIT);
		log.trace(InterfaceUtils.END);
		return "register.html";
	}
	
	@PostMapping("/register-success")
	public String registered(@Valid @ModelAttribute("client") Client client, BindingResult br) {
		log.trace(InterfaceUtils.INIT);
		
		if(clientService.searchByDni(client.getDni()) == null) {
			return "error.html";
		}
		
		clientService.insertNewClient(client);
		
		log.trace(InterfaceUtils.END);
		return "register-success.html";
	}
				
	@GetMapping("/search-name-client")
	public String searchByName() {
		log.trace(InterfaceUtils.INIT);
		log.trace(InterfaceUtils.END);
		return "search-name";
	}
	
	@PostMapping("/show-name-client")
	public String showClientByName(@Valid @ModelAttribute("client") Client client, Model model, BindingResult br) {
		log.trace(InterfaceUtils.INIT);
		
		List<Client> clients = clientService.searchByNameAndSurname(client.getName(), client.getSurname());
		model.addAttribute("clients", clients);
		for (Client client2 : clients) {
			System.out.println(client2.toString());
		}
		if(clients.isEmpty()) {
			return "no-results.html";
		}

		log.trace(InterfaceUtils.END);	
		return "show-name-client.html";
	}
	
	@GetMapping("/search-dni")
	public String searchByDni() {
		log.trace(InterfaceUtils.INIT);
		log.trace(InterfaceUtils.END);
		return "search-dni.html";
	}
	
	@PostMapping("/show-dni-client")
	public String showClientByDni(@Valid @ModelAttribute("client") Client client, Model model, BindingResult br) {
		log.trace(InterfaceUtils.INIT);
		
		List<Client> clients = clientService.searchByDni(client.getDni());
		model.addAttribute("clients", clients);
		
		if(clients.isEmpty()) {
			return "no-results.html";
		}
		
		log.trace(InterfaceUtils.END);
		return "show-dni-client.html";
	}
}
