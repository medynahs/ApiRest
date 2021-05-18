package com.ariane.apirest.ApiRest.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.ariane.apirest.ApiRest.event.RecursoCriadoEvent;
import com.ariane.apirest.ApiRest.model.Desafio;
import com.ariane.apirest.ApiRest.repository.DesafioRepository;
import com.ariane.apirest.ApiRest.service.DesafioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/desafios")
public class DesafioResource {


    @Autowired
    private DesafioRepository desafioRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private DesafioService desafioService;

    @GetMapping
    public List<Desafio> listar() {

        return desafioRepository.findAll();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Desafio> criar(@Valid @RequestBody Desafio desafio, HttpServletResponse response){

       Desafio desafioSalvo = desafioRepository.save(desafio);

       publisher.publishEvent(new RecursoCriadoEvent(this, response, desafioSalvo.getId()));


       return ResponseEntity.status(HttpStatus.CREATED).body(desafioSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Desafio> buscarPeloId(@PathVariable Long id) {
        Optional<Desafio> desafio = desafioRepository.findById(id);
		return desafio.isPresent() ? ResponseEntity.ok(desafio.get()) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        desafioRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Desafio> atualizar(@PathVariable Long id, @Valid @RequestBody Desafio desafio){

        Desafio desafioSalvo = desafioService.atualizar(id, desafio);
        return ResponseEntity.ok(desafioSalvo);
    }

}

