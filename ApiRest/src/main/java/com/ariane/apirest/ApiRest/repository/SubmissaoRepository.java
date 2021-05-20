package com.ariane.apirest.ApiRest.repository;

import com.ariane.apirest.ApiRest.model.Submissao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissaoRepository extends JpaRepository<Submissao, Long>{
    
}
