package br.edu.infnet.appendereco.model.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appendereco.model.domain.Usuario;

@Repository
public class UsuarioDao implements UserDetailsService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioRepository.findByEmail(username);
		
		if(usuario ==null) {
			throw new UsernameNotFoundException("O usuário " + username + " não foi encontrado");

			
		}
		return usuario;
	}

}
