package com.ariane.apirest.ApiRest.service;

import java.util.Optional;
import com.ariane.apirest.ApiRest.model.Submissao;
import com.ariane.apirest.ApiRest.repository.SubmissaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;

@Service
public class SubmissaoService {

    @Autowired
	private SubmissaoRepository submissaoRepository;
    
    public Submissao atualizar(Long id, Submissao submissao) {
		Submissao submissaoSalva = buscarSubmissaoPeloId(id);
	
		BeanUtils.copyProperties(submissao, submissaoSalva, "id");
		return submissaoRepository.save(submissaoSalva);
	}

    public Submissao buscarSubmissaoPeloId(Long id) {
		Optional<Submissao> submissaoSalva = submissaoRepository.findById(id);
		
		if(!submissaoSalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return submissaoSalva.get();
	}
    
}