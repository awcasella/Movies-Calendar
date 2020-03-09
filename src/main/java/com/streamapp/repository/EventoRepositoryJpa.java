package com.streamapp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.streamapp.models.Evento;

@Repository
@Transactional
public interface EventoRepositoryJpa extends PagingAndSortingRepository<Evento,Long>, JpaSpecificationExecutor<Evento> {
	
	@Query(value = "SELECT e from Evento e where e.date like ?1% order by e.date")
    List<Evento> findByNameAndSort(String name, Sort sort);
	
	@Query(value = "select e from Evento e where e.date > ?1 order by e.date")
	List<Evento> findByDate(String date, Sort sort);
}
