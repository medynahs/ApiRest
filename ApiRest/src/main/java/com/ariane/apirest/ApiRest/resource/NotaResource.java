package com.ariane.apirest.ApiRest.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.ariane.apirest.ApiRest.event.RecursoCriadoEvent;
import com.ariane.apirest.ApiRest.model.Nota;
import com.ariane.apirest.ApiRest.repository.NotaRepository;
import com.ariane.apirest.ApiRest.service.NotaService;

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
@RequestMapping("/notas")
public class NotaResource {


    @Autowired
    private NotaRepository notaRepository;
    
    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private NotaService notaService;

    @GetMapping
    public List<Nota> listar() {

        return notaRepository.findAll();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Nota> criar(@Valid @RequestBody Nota nota, HttpServletResponse response){

       Nota notaSalva = notaRepository.save(nota);

       publisher.publishEvent(new RecursoCriadoEvent(this, response, notaSalva.getId()));


       return ResponseEntity.status(HttpStatus.CREATED).body(notaSalva);

    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Nota> buscarPeloId(@PathVariable Long id) {
        Optional<Nota> nota = notaRepository.findById(id);
		return nota.isPresent() ? ResponseEntity.ok(nota.get()) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        notaRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> atualizar(@PathVariable Long id, @Valid @RequestBody Nota nota){

        Nota notaSalva = notaService.atualizar(id, nota);
        return ResponseEntity.ok(notaSalva);
    }

}