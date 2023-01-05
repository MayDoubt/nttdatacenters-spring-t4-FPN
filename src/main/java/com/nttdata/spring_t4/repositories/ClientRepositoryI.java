package com.nttdata.spring_t4.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Taller 3 Spring
 * 
 * Client Repository Interface
 * 
 * @author Fernando Pérez Nieto
 *
 */
@Repository
public interface ClientRepositoryI extends JpaRepository<Client, Long> {

	public List<Client> findByNameAndSurname(String name, String surname);

	public List<Client> findByDni(String dni);
}
