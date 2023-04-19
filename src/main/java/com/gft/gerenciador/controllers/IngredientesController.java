package com.gft.gerenciador.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.gerenciador.entities.Ingredientes;
import com.gft.gerenciador.services.IngredientesService;

@Controller
@RequestMapping("ingredientes")
public class IngredientesController {
	
	@Autowired
	private IngredientesService ingredientesService;
	
	@RequestMapping(path = "novo") //** Acesso na página http://localhost:8080/ingredientes/novo**//
	public ModelAndView novoIngrediente() {
		
		
		
		ModelAndView mv = new ModelAndView("ingredientes/form.html");
		mv.addObject("ingredientes", new Ingredientes());
		
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "novo")
	public ModelAndView salvarIngrediente(@Valid Ingredientes ingredientes, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("ingredientes/form.html");
		
		boolean novo = true;
		
		if(ingredientes.getId() != null){
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("ingredientes", ingredientes);
			return mv;
		}
		
		Ingredientes ingredientesSalva = ingredientesService.salvarIngredientes(ingredientes);
		
		if(novo) {
			mv.addObject("ingredientes", new Ingredientes());
		}else {
			mv.addObject("ingredientes", ingredientesSalva);
		}
		
		mv.addObject("mensagem", "Ingrediente salvo com sucesso!");
		
		return mv;
		
	}
	
	@RequestMapping //**Acesso na página http://localhost:8080/ingredientes/novo**//
	public ModelAndView listarIngredientes() {
		
		ModelAndView mv = new ModelAndView("ingredientes/listar.html");
		mv.addObject("lista", ingredientesService.listarIngredientes());
		
		return mv;
		
		
	}
	
	@RequestMapping("/editar")
	public ModelAndView editarIngrediente(@RequestParam Long id) {
		
		ModelAndView mv = new ModelAndView("ingredientes/form.html");
		Ingredientes ingredientes;
		try {
			ingredientes = ingredientesService.obterIngredientes(id);
			
		}catch(Exception e) {
			ingredientes = new Ingredientes();
			mv.addObject("mensagem", e.getMessage());
			
		}
		
		mv.addObject("ingredientes", ingredientes);
		
		return mv;
		
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirIngrediente(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/ingredientes");
		
		try {
			ingredientesService.excluirIngredientes(id);
			redirectAttributes.addFlashAttribute("mensagem", "Ingrediente excluído com sucesso!");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir ingrediente!"+e.getMessage());			
		}
		
		return mv;
		
	}
	
	

}
