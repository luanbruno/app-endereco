package br.edu.infnet.appendereco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.appendereco.model.domain.Endereco;
import br.edu.infnet.appendereco.model.service.EnderecoService;

@Controller
public class EnderecoController {
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping(value = "/enderecos")
	public String telaLista(Model model) {
		
		model.addAttribute("lista", enderecoService.obterLista());
		
		return "endereco/lista";
	}
	@GetMapping(value = "/endereco")
	public String telaCadastro() {
		return "endereco/cadastro";
	}
	@PostMapping(value = "/endereco")
	public String buscar(Model model, @RequestParam String cep) {
		
		Endereco endereco = enderecoService.obterPorCep(cep);
				
		model.addAttribute("endereco", endereco);
		
		return "endereco/cadastro";
	}
	
	@PostMapping(value = "/endereco/incluir")
	public String incluir(Endereco endereco) {
		enderecoService.incluir(endereco);
		return "redirect:/enderecos";
	}
	@GetMapping(value = "/endereco/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		enderecoService.excluir(id);
		return "redirect:/enderecos";
	}
	
}
