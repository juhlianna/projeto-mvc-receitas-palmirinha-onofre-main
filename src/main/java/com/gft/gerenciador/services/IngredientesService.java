package com.gft.gerenciador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gft.gerenciador.entities.Ingredientes;
import com.gft.gerenciador.repositories.IngredientesRepository;

@Service
public class IngredientesService {
	
	@Autowired
	private IngredientesRepository ingredientesRepository;
	
	public Ingredientes salvarIngredientes(Ingredientes ingredientes) {
		return ingredientesRepository.save(ingredientes);
		
	}
	
	public Ingredientes obterIngredientes(Long id) throws Exception{
		Optional<Ingredientes> ingredientes = ingredientesRepository.findById(id);
		
		if(ingredientes.isEmpty()) {
			throw new Exception("Ingrediente não encontrado");
		}		
		return ingredientes.get();
		}
	
	public List<Ingredientes> listarIngredientes(){
		return ingredientesRepository.findAll();
	}
	
	public void excluirIngredientes(Long id) {
		ingredientesRepository.deleteById(id);
		
	}
	
	public void salvarTodos(List<Ingredientes> listaIngredientes) {
		ingredientesRepository.saveAll(listaIngredientes);

	}

	

}
