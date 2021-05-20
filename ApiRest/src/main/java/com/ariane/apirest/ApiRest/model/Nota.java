package com.ariane.apirest.ApiRest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

@Entity
@Table(name = "notas")
public class Nota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //submissao

    @NotNull
    private int notaQualidadeCodigo;

    @NotNull
    private int notaQuantidadeEntregada;

    /*
    @NotBlank(message = "Nome é necessário.")
    @Size(min = 3, max =20)
    */

    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public int getNotaQualidadeCodigo(){
        return notaQualidadeCodigo;
    }

    public void setNotaQualidadeCodigo(int notaQualidadeCodigo){
        this.notaQualidadeCodigo = notaQualidadeCodigo;
    }

    public int getNotaQuantidadeEntregada(){
        return notaQuantidadeEntregada;
    }

    public void setNotaQuantidadeEntregada(int notaQuantidadeEntregada){
        this.notaQuantidadeEntregada = notaQuantidadeEntregada;
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
		Nota other = (Nota) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}