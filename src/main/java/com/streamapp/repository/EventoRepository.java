package com.streamapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.streamapp.models.Evento;

@Repository
public interface EventoRepository extends CrudRepository<Evento, String>{

	// Find a movie by its code
	Evento findByCode(long code); 
	
}
