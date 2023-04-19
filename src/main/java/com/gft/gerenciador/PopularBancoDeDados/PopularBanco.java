package com.gft.gerenciador.PopularBancoDeDados;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gft.gerenciador.entities.Ingredientes;
import com.gft.gerenciador.entities.ItensReceita;
import com.gft.gerenciador.entities.Receita;
import com.gft.gerenciador.entities.UnidadeMedida;
import com.gft.gerenciador.entities.Usuario;
import com.gft.gerenciador.repositories.IngredientesRepository;
import com.gft.gerenciador.repositories.ItensReceitaRepository;
import com.gft.gerenciador.repositories.ReceitaRepository;
import com.gft.gerenciador.repositories.UnidadeMedidaRepository;
import com.gft.gerenciador.repositories.UsuarioRepository;

//**CLASSE USADA PARA POPULAR BANCO DE DADOS. 

@Configuration
@Profile("test")
public class PopularBanco implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private IngredientesRepository ingredientesRepository;
	
	@Autowired
	private UnidadeMedidaRepository unidadeMedidaRepository;
	
	@Autowired
	private ItensReceitaRepository itensReceitaRepository;
	
	@Autowired
	private ReceitaRepository receitaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		//**CADASTRO DE USUÁRIOS ** TESTE GMAIL
		Usuario u1 = new Usuario(null, "Maria", "MARI", "maria@gmail.com", "12345");
		Usuario u2 = new Usuario(null, "Marcos", "MARC", "marcos@gmail.com", "54321");
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		
		//**CADASTRO DE USUÁRIOS ** TESTE GFT
		Usuario u3 = new Usuario(null, "Joana", "JOAN", "joana@gft.com", "12345");
		Usuario u4 = new Usuario(null, "Murilo", "MURI", "murilo@gft.com", "54321");
			
		usuarioRepository.saveAll(Arrays.asList(u3, u4));
		
		
		//**CADASTRO DE INGREDIENTES
		Ingredientes i1 = new Ingredientes(null, "Farinha");
		Ingredientes i2 = new Ingredientes(null, "Leite");
		Ingredientes i3 = new Ingredientes(null, "Ovos");
		Ingredientes i4 = new Ingredientes(null, "Chocolate em pó");
		Ingredientes i5 = new Ingredientes(null, "Fermento");
		Ingredientes i6 = new Ingredientes(null, "Margarina");
		Ingredientes i7 = new Ingredientes(null, "Água");
		Ingredientes i8 = new Ingredientes(null, "Óleo");		
		
		ingredientesRepository.saveAll(Arrays.asList(i1, i2, i3, i4, i5, i6, i7, i8));
		
		
		
		//**CADASTRO DE UNIDADE DE MEDIDA
		UnidadeMedida udm1 = new UnidadeMedida(null, "Xícara", "xic");
		UnidadeMedida udm2 = new UnidadeMedida(null, "Colher de sopa", "cs");
		UnidadeMedida udm3 = new UnidadeMedida(null, "Colher de chá", "cc");
		UnidadeMedida udm4 = new UnidadeMedida(null, "Xícara", "xic");
		UnidadeMedida udm5 = new UnidadeMedida(null, "Gramas", "g");
		UnidadeMedida udm6 = new UnidadeMedida(null, "quilogramas", "kg");
		UnidadeMedida udm7 = new UnidadeMedida(null, "Unidade", "un");
		UnidadeMedida udm8 = new UnidadeMedida(null, "Mililitros", "ml");
		
		
		unidadeMedidaRepository.saveAll(Arrays.asList(udm1, udm2, udm3, udm4, udm5, udm6, udm7, udm8));
		
		//**CADASTRO DE RECEITA		
		Receita rec1 = new Receita(null, "Bolo de Chocolate", "Misture todos os ingredientes e leve ao forno na temperatura de 180 graus", "45 minutos");
		
		receitaRepository.save(rec1);
		
		//**CADASTRO DOS ITENS DA RECEITA		
		ItensReceita intR1 = new ItensReceita("2", udm1, i1);
		ItensReceita intR2 = new ItensReceita("150", udm8, i2);
		ItensReceita intR3 = new ItensReceita("3", udm7, i3);
		ItensReceita intR4 = new ItensReceita("100", udm5, i4);
		ItensReceita intR5 = new ItensReceita("1", udm2, i6);
		ItensReceita intR6 = new ItensReceita("1", udm2, i5);		
				
		itensReceitaRepository.saveAll(Arrays.asList(intR1, intR2, intR3, intR4, intR5, intR6));		
		
		
	}

}
