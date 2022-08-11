package net.brianlucius.dojos_ninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import net.brianlucius.dojos_ninjas.models.Ninja;
import net.brianlucius.dojos_ninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
}
