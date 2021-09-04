package com.jordans.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jordans.languages.models.Language;
import com.jordans.languages.repositories.LangRepo;

@Service
public class LangService {
	private final LangRepo langRepo;
	
	public LangService(LangRepo langRepo) {
		this.langRepo = langRepo;
	}
	
	public List<Language> allLangs() {
		return langRepo.findAll();
	}
	
	public Language addLanguage(Language lang) {
		return langRepo.save(lang);
	}
	
	public void destroyLang(Long id) {
		langRepo.deleteById(id);
	}

	public Language findLanguage(Long id) {
		Optional<Language> optLang = langRepo.findById(id);
		if(optLang.isPresent()) {
			return optLang.get();
		} else {
			return null;
		}
	}
	
	public void updateLang(Language lang) {
		langRepo.save(lang);
	}
	

}
