package com.ariane.apirest.ApiRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.ariane.apirest.ApiRest.model.Nota;
import com.ariane.apirest.ApiRest.repository.NotaRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;

@Service
public class NotaService {

    @Autowired
	private NotaRepository notaRepository;
    
    public Nota atualizar(Long id, Nota nota) {
		Nota notaSalva = buscarNotaPeloId(id);
	
		BeanUtils.copyProperties(nota, notaSalva, "id");
		return notaRepository.save(notaSalva);
	}

    public Nota buscarNotaPeloId(Long id) {
		Optional<Nota> notaSalva = notaRepository.findById(id);
		
		if(!notaSalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return notaSalva.get();
	}
    
}
