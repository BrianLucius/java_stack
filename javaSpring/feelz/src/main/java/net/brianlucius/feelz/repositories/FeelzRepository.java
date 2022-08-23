package net.brianlucius.feelz.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.brianlucius.feelz.models.Feelz;

@Repository
public interface FeelzRepository extends CrudRepository<Feelz, Long> {
	

}
