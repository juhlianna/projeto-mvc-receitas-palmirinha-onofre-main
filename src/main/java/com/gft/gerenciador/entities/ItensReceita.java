package com.gft.gerenciador.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gft.gerenciador.entities.pk.ItensReceitaPK;

@Entity
@Table(name = "tb_itens_receita")
public class ItensReceita implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ItensReceitaPK id = new ItensReceitaPK();	
	
		
	private String quantidade;
	
	
	
	public ItensReceita() {
		
	}

	public ItensReceita( String quantidade, UnidadeMedida unidadeMedida,  Ingredientes ingredientes ) {
		super();
		this.quantidade = quantidade;
		id.setUnidadeMedida(unidadeMedida);		
		id.setIngredientes(ingredientes);
		
	}
	
	@JsonIgnore
	public UnidadeMedida getUnidadeMedida() {
		return id.getUnidadeMedida();
	}
	
	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		id.setUnidadeMedida(unidadeMedida);
	}
	
		
	public Ingredientes getIngredientes() {
		return id.getIngredientes();
		
	}
	
	public void setIngredientes(Ingredientes ingredientes) {
		id.setIngredientes(ingredientes);
	}	

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
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
		ItensReceita other = (ItensReceita) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	
	
	

	
	
	

}
