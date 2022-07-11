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
	private RoleService roleService;

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		if (roleService.obterPornome("ROLE_ADMIN") == null) {
			roleService.incluir(new Role("ROLE_ADMIN"));
		}

		if (roleService.obterPornome("ROLE_USER") == null) {
			roleService.incluir(new Role("ROLE_USER"));
		}
		
		Endereco enderecoA = new Endereco();
		enderecoA.setBairro("bairro luan");
		enderecoA.setCep("26857874");
		enderecoA.setComplemento("complemento luan");
		enderecoA.setLocalidade("localidade luan");
		enderecoA.setLogradouro("logradouro luan");
		enderecoA.setUf("uf luan");
		
		Usuario usuarioA = new Usuario();
		usuarioA.setEmail("admin@infnet.edu.br");
		usuarioA.setEndereco(enderecoA);
		usuarioA.setNome("luan");
		usuarioA.setRoles(Arrays.asList(new Role(1)));
		usuarioA.setSenha("123");
				
		usuarioService.incluir(usuarioA);
		
		Endereco enderecoB = new Endereco();
		enderecoB.setBairro("bairro elis");
		enderecoB.setCep("cep elis");
		enderecoB.setComplemento("complemento elis");
		enderecoB.setLocalidade("localidade elis");
		enderecoB.setLogradouro("logradouro elis");
		enderecoB.setUf("uf elis");
		
		Usuario usuarioB = new Usuario();
		usuarioB.setEmail("elis@elis.com");
		usuarioB.setEndereco(enderecoB);
		usuarioB.setNome("Elis");
		usuarioB.setRoles(Arrays.asList(new Role(2)));
		usuarioB.setSenha("123");

		usuarioService.incluir(usuarioB);
		
		Endereco enderecoC = new Endereco();
		enderecoC.setBairro("bairro Moraes");
		enderecoC.setCep("cep Moraes");
		enderecoC.setComplemento("complemento Moraes");
		enderecoC.setLocalidade("localidade Moraes");
		enderecoC.setLogradouro("logradouro Moraes");
		enderecoC.setUf("uf Moraes");
		
		Usuario moraes = new Usuario();
		moraes.setEmail("moraes@moraes.com");
		moraes.setEndereco(enderecoC);
		moraes.setNome("Moraes");
		moraes.setRoles(Arrays.asList(new Role(1), new Role(2)));
		moraes.setSenha("123");
		
		usuarioService.incluir(moraes);
		
		
		
		
	}
	

}
