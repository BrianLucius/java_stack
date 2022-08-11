package net.brianlucius.dojos_ninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.brianlucius.dojos_ninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {

	List<Dojo> findAll();
	List<Dojo> findByOrderByName();
}
