package com.modelo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.modelo.model.Aluno;
import com.modelo.reposity.CrudAluno;
@Controller
public class HomeController {
	@Autowired
	private CrudAluno crud;
	
	
	@GetMapping("/")
	public ModelAndView tela() {
		ModelAndView modelAndView= new ModelAndView("tela");
		modelAndView.addObject("aluno", crud.findAll());
		return modelAndView;
		
	}
	
	
	
	@GetMapping("/cadastro")
	public ModelAndView index() {
		ModelAndView modelAndView= new ModelAndView("index");
		modelAndView.addObject("aluno", crud.findAll());
		return modelAndView;
		
	}
	
	@PostMapping("/salvar")
	public String salvar(Aluno aluno) {
		crud.save(aluno);
		return "/index";
		
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {
		
		crud.deleteById(id);		
		ModelAndView modelAndView= new ModelAndView("index");
		modelAndView.addObject("aluno", crud.findAll());
		return modelAndView;
	}
	
	@RequestMapping("/edit/{id}")

	public String edit(@PathVariable("id") int id, Model model) {
		Optional<Aluno> aluno = crud.findById(id);
		model.addAttribute("alunoEditar", model);
		return "editar";
		 
	}
	
	
	
	

}
