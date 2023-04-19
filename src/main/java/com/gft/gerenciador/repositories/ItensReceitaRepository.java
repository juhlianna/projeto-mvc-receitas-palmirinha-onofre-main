package com.gft.gerenciador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.gerenciador.entities.ItensReceita;
import com.gft.gerenciador.entities.pk.ItensReceitaPK;

@Repository
public interface ItensReceitaRepository extends JpaRepository<ItensReceita, ItensReceitaPK > {

}
