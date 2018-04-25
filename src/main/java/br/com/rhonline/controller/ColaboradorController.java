package br.com.rhonline.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rhonline.model.Colaborador;
import br.com.rhonline.service.ColaboradorService;


@Controller
@RequestMapping("/colaborador")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService service;	
	
	@RequestMapping("/save")
	@PostMapping
	public String save(@RequestBody Colaborador colaborador, Model model) throws Exception {		
		service.save(colaborador);
		return "sucesso";
	}
}
