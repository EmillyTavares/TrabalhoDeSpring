package com.modelo.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.modelo.model.Aluno;
import com.modelo.reposity.CrudAluno;
@Controller
public class HomeController {
	@Autowired
	private CrudAluno crud;
	
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView= new ModelAndView("tela");
		modelAndView.addObject("aluno", crud.findAll());
		return modelAndView;
		
	}
	
	
	
	@GetMapping("/cadastro")
	public ModelAndView cadastro() {
		ModelAndView modelAndView= new ModelAndView("index1");
		modelAndView.addObject("aluno", crud.findAll());
		return modelAndView;
		
	}
	
	@GetMapping("/salvar")
	public String salvar(@Valid Aluno aluno, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return "redirect:/cadastro";
		}
		crud.save(aluno);
		attributes.addFlashAttribute("mensagem", "Formando salvo com sucesso");
		return "redirect:/cadastro";
		
	}
	@GetMapping("/ef")
	public String editar( @Valid Aluno aluno, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return "redirect:/cadastro";
		}
		
		attributes.addFlashAttribute("ef", "Formando editado com sucesso");
		crud.save(aluno);
		return "redirect:/cadastro";
		
	}
	@PostMapping("/ex")
	public String excluir( @Valid Aluno aluno, BindingResult result, RedirectAttributes attributes, int id) {
		if(result.hasErrors()) {
			return "redirect:/cadastro";
		}
		crud.deleteById(id);	
		attributes.addFlashAttribute("ex", "Formando excluido com sucesso");
	
		return "redirect:/cadastro";
		
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {
		
		crud.deleteById(id);		
		ModelAndView modelAndView= new ModelAndView("index1");
		modelAndView.addObject("aluno", crud.findAll());
		return modelAndView;
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		model.addAttribute("aluno", crud.findById(id));
		return "editar";
		
	}
	
	
	
	
	

}
