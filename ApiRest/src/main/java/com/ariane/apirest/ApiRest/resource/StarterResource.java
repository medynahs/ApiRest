package com.ariane.apirest.ApiRest.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import com.ariane.apirest.ApiRest.model.Starter;
import com.ariane.apirest.ApiRest.repository.StarterRepository;

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
@RequestMapping("/starters")
public class StarterResource {


    @Autowired
    private StarterRepository starterRepository;

    @GetMapping
    public List<Starter> listar() {

        return starterRepository.findAll();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Starter> criar(@RequestBody Starter starter, HttpServletResponse response){

       Starter starterSalvo = starterRepository.save(starter);

       URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(starterSalvo.getId()).toUri();
       response.setHeader("Location", uri.toASCIIString());

       return ResponseEntity.created(uri).body(starterSalvo);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Starter> buscarPeloId(@PathVariable Long id) {
        Optional<Starter> starter = starterRepository.findById(id);
		return starter.isPresent() ? ResponseEntity.ok(starter.get()) : ResponseEntity.notFound().build();
    }

}
