package br.edu.infnet.appendereco.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.infnet.appendereco.model.Repository.UsuarioRepository;
import br.edu.infnet.appendereco.model.domain.Usuario;
@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void incluir(Usuario usuario) {
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
		usuarioRepository.save(usuario);
	}

	public void excluir(Integer id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario autenticar(String email, String senha) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if (usuario != null) {

			if (usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		return null;
	}

}
