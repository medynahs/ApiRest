package com.ariane.apirest.ApiRest.repository;

import com.ariane.apirest.ApiRest.model.Nota;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long>{
    
}
