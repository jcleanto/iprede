package org.isgh.iprede.controller;

import java.util.ArrayList;
import java.util.List;

import org.isgh.iprede.model.UsuarioTipo;
import org.isgh.iprede.repository.UsuarioTipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioTiposController {
	
	@Autowired
	private UsuarioTipos usuarioTipos;
	
	@GetMapping(value = "/usuariotipos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UsuarioTipo>> listUsuarioTipos() {
		List<UsuarioTipo> list = new ArrayList<UsuarioTipo>();
		Iterable<UsuarioTipo> itUsuarioTipos = usuarioTipos.findAll();
		itUsuarioTipos.forEach(list::add);
		return new ResponseEntity<List<UsuarioTipo>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/usuariotipos/findbyflgativo/{flgAtivo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UsuarioTipo>> findUsuarioTiposByFlgAtivo(@PathVariable(required = true) boolean flgAtivo) {
		List<UsuarioTipo> list = new ArrayList<UsuarioTipo>();
		Iterable<UsuarioTipo> itUsuarioTipos = usuarioTipos.findUsuarioTiposByFlgAtivo(flgAtivo);
		itUsuarioTipos.forEach(list::add);
		return new ResponseEntity<List<UsuarioTipo>>(list, HttpStatus.OK);
	}

}
