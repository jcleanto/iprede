package org.isgh.iprede.service;

import org.isgh.iprede.model.Usuario;
import org.isgh.iprede.model.UsuarioTipo;
import org.isgh.iprede.repository.UsuarioTipos;
import org.isgh.iprede.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private Usuarios usuarios;

	@Autowired
	private UsuarioTipos usuarioTipos;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Usuario findUsuarioByEmail(String email) {
		return usuarios.findUsuarioByEmail(email);
	}

	@Override
	public void saveUsuario(Usuario usuario) {
		usuario.setDscSenha(bCryptPasswordEncoder.encode(usuario.getDscSenha()));
		usuario.setFlgAtivo(true);
		UsuarioTipo usuarioTipo = usuarioTipos.findUsuarioTipoByTipo("Sistema");
		usuario.setUsuarioTipo(usuarioTipo);
		usuarios.save(usuario);
	}

}
