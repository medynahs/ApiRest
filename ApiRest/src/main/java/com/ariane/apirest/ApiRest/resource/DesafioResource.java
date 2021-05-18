package com.ariane.apirest.ApiRest.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.ariane.apirest.ApiRest.model.Desafio;
import com.ariane.apirest.ApiRest.repository.DesafioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/desafios")
public class DesafioResource {


    @Autowired
    private DesafioRepository desafioRepository;

    @GetMapping
    public List<Desafio> listar() {

        return desafioRepository.findAll();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Desafio> criar(@Valid @RequestBody Desafio desafio, HttpServletResponse response){

       Desafio desafioSalvo = desafioRepository.save(desafio);

       URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(desafioSalvo.getId()).toUri();
       response.setHeader("Location", uri.toASCIIString());

       return ResponseEntity.created(uri).body(desafioSalvo);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Desafio> buscarPeloId(@PathVariable Long id) {
        Optional<Desafio> desafio = desafioRepository.findById(id);
		return desafio.isPresent() ? ResponseEntity.ok(desafio.get()) : ResponseEntity.notFound().build();
    }

}

