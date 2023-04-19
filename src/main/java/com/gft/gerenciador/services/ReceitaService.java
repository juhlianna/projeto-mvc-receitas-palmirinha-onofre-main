package com.gft.gerenciador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.gerenciador.entities.Receita;
import com.gft.gerenciador.repositories.ReceitaRepository;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	public Receita salvarReceita(Receita receita) {
		return receitaRepository.save(receita);
	}
	
	public Receita obterReceita(Long id) throws Exception{
		Optional<Receita> receita = receitaRepository.findById(id);
		
		if(receita.isEmpty()) {
			throw new Exception("Receita não encontrada");
		}
		return receita.get();		
	}
	
	public List<Receita> listarReceita(){
		return receitaRepository.findAll();
		
	}
	
	public void excluirReceita(Long id) {
		receitaRepository.deleteById(id);
		
	}
	
	public void salvarTodos(List<Receita> listaReceitas) {
		receitaRepository.saveAll(listaReceitas);

	}
	
	

}
