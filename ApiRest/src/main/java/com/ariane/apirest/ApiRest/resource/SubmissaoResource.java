package com.ariane.apirest.ApiRest.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.ariane.apirest.ApiRest.event.RecursoCriadoEvent;
import com.ariane.apirest.ApiRest.model.Submissao;
import com.ariane.apirest.ApiRest.repository.SubmissaoRepository;
import com.ariane.apirest.ApiRest.service.SubmissaoService;

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
@RequestMapping("/submissoes")
public class SubmissaoResource {


    @Autowired
    private SubmissaoRepository submissaoRepository;
    
    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private SubmissaoService submissaoService;

    @GetMapping
    public List<Submissao> listar() {

        return submissaoRepository.findAll();

    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Submissao> criar(@Valid @RequestBody Submissao submissao, HttpServletResponse response){

       Submissao submissaoSalva = submissaoRepository.save(submissao);

       publisher.publishEvent(new RecursoCriadoEvent(this, response, submissaoSalva.getId()));


       return ResponseEntity.status(HttpStatus.CREATED).body(submissaoSalva);

    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Submissao> buscarPeloId(@PathVariable Long id) {
        Optional<Submissao> submissao = submissaoRepository.findById(id);
		return submissao.isPresent() ? ResponseEntity.ok(submissao.get()) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        submissaoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Submissao> atualizar(@PathVariable Long id, @Valid @RequestBody Submissao submissao){

        Submissao submissaoSalva = submissaoService.atualizar(id, submissao);
        return ResponseEntity.ok(submissaoSalva);
    }

}
