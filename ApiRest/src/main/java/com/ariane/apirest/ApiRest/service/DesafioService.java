package com.ariane.apirest.ApiRest.service;


import java.util.Optional;

import com.ariane.apirest.ApiRest.model.Desafio;
import com.ariane.apirest.ApiRest.repository.DesafioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;

@Service
public class DesafioService {

    @Autowired
	private DesafioRepository desafioRepository;
    
    public Desafio atualizar(Long id, Desafio desafio) {
		Desafio desafioSalvo = buscarDesafioPeloId(id);
	
		BeanUtils.copyProperties(desafio, desafioSalvo, "id");
		return desafioRepository.save(desafioSalvo);
	}

    public Desafio buscarDesafioPeloId(Long id) {
		Optional<Desafio> desafioSalvo = desafioRepository.findById(id);
		
		if(!desafioSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return desafioSalvo.get();
	}
    
}

