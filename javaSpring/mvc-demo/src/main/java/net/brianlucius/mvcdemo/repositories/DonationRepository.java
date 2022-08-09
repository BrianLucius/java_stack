package net.brianlucius.mvcdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.brianlucius.mvcdemo.models.Donation;

@Repository
public interface DonationRepository extends CrudRepository<Donation, Long> {
	List<Donation> findAll();
}
