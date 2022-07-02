package br.edu.infnet.appendereco;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appendereco.model.domain.Endereco;
import br.edu.infnet.appendereco.model.domain.Role;
import br.edu.infnet.appendereco.model.domain.Usuario;
import br.edu.infnet.appendereco.model.service.RoleService;
import br.edu.infnet.appendereco.model.service.UsuarioService;

@Component
public class UsuarioLoader implements ApplicationRunner{

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RoleService roleService;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		roleService.incluir(new Role("ROLE_ADMIN"));
		roleService.incluir(new Role("ROLE_USER"));
		
		Endereco enderecoElberth = new Endereco();
		enderecoElberth.setBairro("bairro elberth");
		enderecoElberth.setCep("cep elberth");
		enderecoElberth.setComplemento("complemento elberth");
		enderecoElberth.setLocalidade("localidade elberth");
		enderecoElberth.setLogradouro("logradouro elberth");
		enderecoElberth.setUf("uf elberth");
		

		Usuario elberth = new Usuario();
		elberth.setEmail("elberth@elberth.com");
		elberth.setEndereco(enderecoElberth);
		elberth.setNome("Elberth");
		elberth.setRoles(Arrays.asList(new Role(1)));
		elberth.setSenha("123");
		
		
		usuarioService.incluir(elberth);
		
		Endereco enderecoElis = new Endereco();
		enderecoElis.setBairro("bairro elis");
		enderecoElis.setCep("cep elis");
		enderecoElis.setComplemento("complemento elis");
		enderecoElis.setLocalidade("localidade elis");
		enderecoElis.setLogradouro("logradouro elis");
		enderecoElis.setUf("uf elis");
		
		Usuario elis = new Usuario();
		elis.setEmail("elis@elis.com");
		elis.setEndereco(enderecoElis);
		elis.setNome("Elis");
		elis.setRoles(Arrays.asList(new Role(2)));
		elis.setSenha("123");

		usuarioService.incluir(elis);
		
		Endereco enderecoMoraes = new Endereco();
		enderecoMoraes.setBairro("bairro Moraes");
		enderecoMoraes.setCep("cep Moraes");
		enderecoMoraes.setComplemento("complemento Moraes");
		enderecoMoraes.setLocalidade("localidade Moraes");
		enderecoMoraes.setLogradouro("logradouro Moraes");
		enderecoMoraes.setUf("uf Moraes");
		
		Usuario moraes = new Usuario();
		moraes.setEmail("moraes@moraes.com");
		moraes.setEndereco(enderecoMoraes);
		moraes.setNome("Moraes");
		moraes.setRoles(Arrays.asList(new Role(1), new Role(2)));
		moraes.setSenha("123");
		
		usuarioService.incluir(moraes);
		
		
		
		
	}
	

}
