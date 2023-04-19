package com.gft.gerenciador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.gerenciador.entities.UnidadeMedida;
import com.gft.gerenciador.repositories.UnidadeMedidaRepository;

@Service
public class UnidadeMedidaService {
	
	@Autowired
	private UnidadeMedidaRepository unidadeMedidaRepository;
	
	
	public UnidadeMedida salvarUnidadeMedida(UnidadeMedida unidadeMedida) {
		return unidadeMedidaRepository.save(unidadeMedida);
	}
	
	
	public UnidadeMedida obterUnidadeMedida(Long id) throws Exception{
		Optional<UnidadeMedida> unidadeMedida = unidadeMedidaRepository.findById(id);
		
		if(unidadeMedida.isEmpty()) {
			throw new Exception("Unidade de Medida não encontrada");
		}
		return unidadeMedida.get();		
	}
	
	public List<UnidadeMedida> listarUnidadeMedida(){
		return unidadeMedidaRepository.findAll();
		
	}
	
	public void excluirUnidadeMedida(Long id) {
		unidadeMedidaRepository.deleteById(id);
		
	}
	
	public void salvarTodos(List<UnidadeMedida> listaUnidadeMedida) {
		unidadeMedidaRepository.saveAll(listaUnidadeMedida);

	}
	
	

}
