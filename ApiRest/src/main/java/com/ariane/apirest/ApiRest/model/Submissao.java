package com.ariane.apirest.ApiRest.model;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "submissoes")
public class Submissao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotBlank(message = "Nome é necessário.")
	private String nome;

	@NotNull(message = "Starter é necessário.")
	@ManyToOne
	private Starter starter;

	@NotNull(message = "Desafio é necessário.")
	@ManyToOne
	private Desafio desafio;

	@NotNull(message = "Endereço é necessário.")
	@Embedded
	private Endereco endereco;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Starter getStarter(){
		return starter;
	}

	public void setStarter(Starter starter){
		this.starter = starter;
	}

	public Desafio getDesafio(){
		return desafio;
	}

	public void setDesafio(Desafio desafio){
		this.desafio = desafio;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Submissao other = (Submissao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
