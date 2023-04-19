package com.gft.gerenciador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.gerenciador.entities.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
	

}
