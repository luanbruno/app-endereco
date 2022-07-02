package br.edu.infnet.appendereco.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.appendereco.model.domain.Usuario;
import br.edu.infnet.appendereco.model.service.UsuarioService;

@SessionAttributes("user")
@Controller
public class AppController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/")
	public String telaIndex() {
		return "index";
	}

	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}
	@GetMapping(value = "/negado")
	public String telaNegado() {
		return "negado";
	}


	@GetMapping(value = "/logout")
	public String telalogout(HttpSession session, SessionStatus status) {

		status.setComplete();

		session.removeAttribute("user");

		return "redirect:/";
	}

	@PostMapping(value = "/login")
	public String login(Model model, @AuthenticationPrincipal Usuario usuario) {
			return "redirect:/";

	}
	
//	@PostMapping(value = "/login")
//	public String login(Model model, @RequestParam String email, @RequestParam String senha) {
//
//		Usuario usuario = usuarioService.autenticar(email, senha);
//
//		if (usuario != null) {
//			model.addAttribute("user", usuario);
//
//			return "redirect:/";
//		} else {
//
//			return "redirect:/login";
//		}
//
//	}

}
