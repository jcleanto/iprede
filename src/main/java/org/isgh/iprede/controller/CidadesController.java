package org.isgh.iprede.controller;

import java.util.ArrayList;
import java.util.List;

import org.isgh.iprede.model.Cidade;
import org.isgh.iprede.repository.Cidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CidadesController {
	
	@Autowired
	private Cidades cidades;
	
	@GetMapping(value = "/cidades", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cidade>> listCidades() {
		List<Cidade> list = new ArrayList<Cidade>();
		Iterable<Cidade> itCidades = cidades.findAll();
		itCidades.forEach(list::add);
		return new ResponseEntity<List<Cidade>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/cidades/findbyuf/{isnUf}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cidade>> listCidadesByUf(@PathVariable(value = "isnUf", required = true) Long isnUf) {
		List<Cidade> list = new ArrayList<Cidade>();
		Iterable<Cidade> itCidades = cidades.findAllByUf(isnUf);
		itCidades.forEach(list::add);
		return new ResponseEntity<List<Cidade>>(list, HttpStatus.OK);
	}

}
