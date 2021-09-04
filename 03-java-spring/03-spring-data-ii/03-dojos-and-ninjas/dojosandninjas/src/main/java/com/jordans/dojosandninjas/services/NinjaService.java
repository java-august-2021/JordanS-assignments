package com.jordans.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jordans.dojosandninjas.models.Ninja;
import com.jordans.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private final NinjaRepository nRepo;
	
	public NinjaService(NinjaRepository nRepo) {
		this.nRepo = nRepo;
	}
	
	public List<Ninja> allNinjas(){
		return nRepo.findAll();
		
	}
	
	public Ninja createNinja(Ninja ninja) {
		return nRepo.save(ninja);
	}
	
	public List<Ninja> theseStudents(Long id){
		return nRepo.findAllById(id);
	}
}
