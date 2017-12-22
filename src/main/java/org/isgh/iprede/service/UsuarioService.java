package org.isgh.iprede.service;

import org.isgh.iprede.model.Usuario;

public interface UsuarioService {
	
	public Usuario findUsuarioByEmail(String email);
	public void saveUsuario(Usuario usuario);

}
