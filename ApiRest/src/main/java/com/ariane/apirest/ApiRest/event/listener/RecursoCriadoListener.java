package com.ariane.apirest.ApiRest.event.listener;

import com.ariane.apirest.ApiRest.event.RecursoCriadoEvent;

import org.springframework.context.ApplicationListener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


//Responsavel por ouvir o evento
@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

	@Override
	public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
		
		HttpServletResponse response = recursoCriadoEvent.getResponse();
		Long id = recursoCriadoEvent.getId();
		
		adicionarHeaderLocation(response, id);
		
	}

	private void adicionarHeaderLocation(HttpServletResponse response, Long id) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(id).toUri();
			response.setHeader("Location", uri.toASCIIString());
	}
	
}