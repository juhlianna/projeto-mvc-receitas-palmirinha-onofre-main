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

import com.gft.gerenciador.entities.UnidadeMedida;
import com.gft.gerenciador.services.UnidadeMedidaService;

@Controller
@RequestMapping("unidadeMedida")
public class UnidadeMedidaController {
	
	@Autowired
	private UnidadeMedidaService unidadeMedidaService;
	
	@RequestMapping(path = "nova") 
	public ModelAndView novoUnidadeMedida() {
		
		
		
		ModelAndView mv = new ModelAndView("unidadeMedida/form.html");
		mv.addObject("unidadeMedida", new UnidadeMedida());
		
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "nova")
	public ModelAndView salvarUnidadeMedida(@Valid UnidadeMedida unidadeMedida, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("unidadeMedida/form.html");
		
		boolean novo = true;
		
		if(unidadeMedida.getId() != null){
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("unidadeMedida", unidadeMedida);
			return mv;
		}
		
		UnidadeMedida unidadeMedidaSalva = unidadeMedidaService.salvarUnidadeMedida(unidadeMedida);
		
		if(novo) {
			mv.addObject("unidadeMedida", new UnidadeMedida());
		}else {
			mv.addObject("unidadeMedida", unidadeMedidaSalva);
		}
		
		mv.addObject("mensagem", "Unidade de Medida salvo com sucesso!");
		
		return mv;
		
	}
	
	@RequestMapping 
	public ModelAndView listarUnidadeMedida() {
		
		ModelAndView mv = new ModelAndView("unidadeMedida/listar.html");
		mv.addObject("lista", unidadeMedidaService.listarUnidadeMedida());
		
		return mv;
		
		
	}
	
	@RequestMapping("/editar")
	public ModelAndView editarUnidadeMedida(@RequestParam Long id) {
		
		ModelAndView mv = new ModelAndView("unidadeMedida/form.html");
		UnidadeMedida unidadeMedida;
		try {
			unidadeMedida = unidadeMedidaService.obterUnidadeMedida(id);
			
		}catch(Exception e) {
			unidadeMedida = new UnidadeMedida();
			mv.addObject("mensagem", e.getMessage());
			
		}
		
		mv.addObject("unidadeMedida", unidadeMedida);
		
		return mv;
		
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirUnidadeMedida(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/unidademedida");
		
		try {
			unidadeMedidaService.excluirUnidadeMedida(id);
			redirectAttributes.addFlashAttribute("mensagem", "Unidade de Medida excluído com sucesso!");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir unidade de Medida!"+e.getMessage());			
		}
		
		return mv;
		
	}
	
	

}
