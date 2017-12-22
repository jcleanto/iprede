package org.isgh.iprede.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.isgh.iprede.exception.RestException;
import org.isgh.iprede.exception.RestExceptionCode;
import org.isgh.iprede.model.Usuario;
import org.isgh.iprede.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuariosController extends AbstractController {
	
	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping(value = "/usuarios/find", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> findUsuariosByName(@RequestBody(required = true) Usuario usuario) {
		List<Usuario> list = new ArrayList<Usuario>();
		String dscUsuario = (usuario.getDscUsuario() != null && !usuario.getDscUsuario().isEmpty())?usuario.getDscUsuario().toUpperCase():"";
		Iterable<Usuario> itUsuarios = usuarios.findUsuariosByName(dscUsuario);
		itUsuarios.forEach(list::add);
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value = "/usuarios/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> saveUsuario(@Valid @RequestBody(required = true) Usuario usuario) {
		usuario.setDscSenha(bCryptPasswordEncoder.encode(usuario.getDscSenha()));
		if (usuario.getIsnUsuario() == null) usuario.setDatCadastro(new Date());
		usuarios.save(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@GetMapping(value = "/usuarios/edit/{isnUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> editUsuario(@PathVariable(value = "isnUsuario", required = true) long isnUsuario) {
		Usuario usuario = usuarios.findUsuarioById(isnUsuario);
		if (usuario == null) {
            throw new RestException("Usuário não encontrado", RestExceptionCode.EC_FE_014);
        }
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	/*@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> loginUsuario(@RequestBody(required = true) AccountCredentials accountCredentials) {
		Usuario usuario = usuarios.findUsuarioByEmail(accountCredentials.getUsername());
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}*/
	
	@PostMapping(value = "/usuarios/findbyemail", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> findUsuariosByEmail(@RequestBody(required = true) Usuario usuario) {
		Usuario usuarioReturn = usuarios.findUsuarioByEmail(usuario.getDscEmail());
		if (usuarioReturn == null) {
            throw new RestException("Usuário não encontrado", RestExceptionCode.EC_FE_014);
        }
		return new ResponseEntity<Usuario>(usuarioReturn, HttpStatus.OK);
	}

}
