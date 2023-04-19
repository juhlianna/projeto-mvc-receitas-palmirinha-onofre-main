package com.gft.gerenciador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.gerenciador.entities.Usuario;
import com.gft.gerenciador.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario insert(Usuario obj) {
		return usuarioRepository.save(obj);
	}
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();		
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.get();
	}


}
