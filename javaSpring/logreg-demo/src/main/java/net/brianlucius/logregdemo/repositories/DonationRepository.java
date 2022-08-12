package net.brianlucius.logregdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.brianlucius.logregdemo.models.Donation;

@Repository
public interface DonationRepository extends CrudRepository<Donation, Long> {

	List<Donation> findAll();
}
