package com.gft.gerenciador.entities;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



@Entity
@Table(name = "tb_receita")
public class Receita implements Serializable {	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotEmpty(message = "Nome não pode ser vazio")
	@Column(name = "nome")
	private String nome;	
		
	@NotEmpty(message = "Este campo não pode ser vazio")
	@Column(name = "modoDePreparo")
	private String modoDePreparo;	
	
	@NotEmpty(message = "Este campo não pode ser vazio")
	@Column(name = "tempoDePreparo")
	private String tempoDePreparo;
	
	@OneToMany(mappedBy = "id.receita")	
	private Set<ItensReceita> itensReceita = new HashSet<>();		
	
			
	public Receita() {
		
	}
	//**CONSTRUTOR**//	
	
	
	public Receita(Long id, String nome, String modoDePreparo,	String tempoDePreparo) {
		super();
		this.id = id;
		this.nome = nome;
		this.modoDePreparo = modoDePreparo;
		this.tempoDePreparo = tempoDePreparo;
	}
	

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
	public String getModoDePreparo() {
		return modoDePreparo;
	}
	public void setModoDePreparo(String modoDePreparo) {
		this.modoDePreparo = modoDePreparo;
	}	
	
	public String getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(String tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}



	public Set<ItensReceita> getItens(){
		return itensReceita;
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
		Receita other = (Receita) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Receita [id=" + id + ", nome=" + nome + ", modoDePreparo=" + modoDePreparo + ", tempoDePreparo="
				+ tempoDePreparo + ", itensReceita=" + itensReceita + "]";
	}
	
	
		
	
	
	

	

		

}
