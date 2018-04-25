package br.com.rhonline.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rhonline.model.Colaborador;
import br.com.rhonline.model.Empresa;
import br.com.rhonline.service.EmpresaService;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
    
	@Autowired
	private EmpresaService service;
	
	@RequestMapping("/listacolaboradores")
	@GetMapping
	public String listarColaboradores(Model model) {
		
		Iterator<Empresa> empresas = service.buscarFuncionarios().iterator();
		List<Colaborador> colaboradores = new ArrayList<>();
		
		while(empresas.hasNext()) {
			empresas.next().getContratos().forEach(c -> colaboradores.add(c.getColaborador()));
		}		
		
		model.addAttribute("colaboradores", colaboradores);
		return "listafuncionarios";
	}
}
