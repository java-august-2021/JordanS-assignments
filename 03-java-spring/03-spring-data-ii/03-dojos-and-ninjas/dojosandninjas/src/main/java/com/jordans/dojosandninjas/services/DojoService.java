package com.jordans.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jordans.dojosandninjas.models.Dojo;
import com.jordans.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dRepository;
	
	public DojoService(DojoRepository dRepo) {
		this.dRepository = dRepo;
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dRepository.save(dojo);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> thisDojo = dRepository.findById(id);
		if(thisDojo.isPresent()) {
			return thisDojo.get();
		} else {
			return null;
		}
	}
	
	public List<Dojo> allDojos(){
		return dRepository.findAll();
	}
	
}
