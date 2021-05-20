package com.ariane.apirest.ApiRest.service;

import java.util.Optional;

import com.ariane.apirest.ApiRest.model.Starter;
import com.ariane.apirest.ApiRest.repository.StarterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;

@Service
public class StarterService {

    @Autowired
	private StarterRepository starterRepository;
    
    public Starter atualizar(Long id, Starter starter) {
		Starter starterSalvo = buscarStarterPeloId(id);
	
		BeanUtils.copyProperties(starter, starterSalvo, "id");
		return starterRepository.save(starterSalvo);
	}

    public Starter buscarStarterPeloId(Long id) {
		Optional<Starter> starterSalvo = starterRepository.findById(id);
		
		if(!starterSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return starterSalvo.get();
	}
    
}
