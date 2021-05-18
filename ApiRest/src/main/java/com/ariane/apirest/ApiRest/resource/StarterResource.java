package com.ariane.apirest.ApiRest.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.ariane.apirest.ApiRest.event.RecursoCriadoEvent;
import com.ariane.apirest.ApiRest.model.Starter;
import com.ariane.apirest.ApiRest.repository.StarterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/starters")
public class StarterResource {


    @Autowired
    private StarterRepository starterRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Starter> listar() {

        return starterRepository.findAll();

    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Starter> criar(@Valid @RequestBody Starter starter, HttpServletResponse response){

       Starter starterSalvo = starterRepository.save(starter);

       publisher.publishEvent(new RecursoCriadoEvent(this, response, starterSalvo.getId()));


       return ResponseEntity.status(HttpStatus.CREATED).body(starterSalvo);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Starter> buscarPeloId(@PathVariable Long id) {
        Optional<Starter> starter = starterRepository.findById(id);
		return starter.isPresent() ? ResponseEntity.ok(starter.get()) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        starterRepository.deleteById(id);
    }

}
