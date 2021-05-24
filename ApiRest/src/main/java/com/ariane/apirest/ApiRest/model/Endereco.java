package com.ariane.apirest.ApiRest.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Embeddable
public class Endereco {

	@NotBlank(message = "Logradouro é necessário.")
    @Size(min = 3, max =150)
	private String logradouro;

	@NotBlank(message = "Número é necessário.")
    @Size(min = 1)
	@Positive
	private String numero;

    @Size(min = 3)
	private String complemento;

	@NotBlank(message = "Bairro é necessário.")
    @Size(min = 3)
	private String bairro;

	@NotBlank(message = "CEP é necessário.")
    @Size(min = 8)
	private String cep;

	@NotBlank(message = "Cidade é necessário.")
    @Size(min = 2)
	private String cidade;

	@NotBlank(message = "Estado é necessário.")
    @Size(min = 2)
	private String estado;
    
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}