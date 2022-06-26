package br.edu.infnet.appendereco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appendereco.model.service.IbgeService;
@Controller
public class IbgeController {
	@Autowired
	public IbgeService ibgeService;
	
	
	@GetMapping(value = "/estados")
	public String telaListaEstado(Model model) {
		
		model.addAttribute("lista", ibgeService.obterLista());
		
		return "estado/lista";
	}	
	
	@GetMapping(value = "/municipios/{uf}")
	public String telaListaMunicipio(Model model,@PathVariable Integer uf) {
		
		model.addAttribute("lista", ibgeService.obterLista(uf));
		
		return "municipio/lista";
	}	
	
}
