package org.isgh.iprede.controller;

import java.util.ArrayList;
import java.util.List;

import org.isgh.iprede.model.Bairro;
import org.isgh.iprede.repository.Bairros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BairrosController {
	
	@Autowired
	private Bairros bairros;
	
	@GetMapping(value = "/bairros", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Bairro>> listBairros() {
		List<Bairro> list = new ArrayList<Bairro>();
		Iterable<Bairro> itBairros = bairros.findAll();
		itBairros.forEach(list::add);
		return new ResponseEntity<List<Bairro>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/bairros/findbycidade/{isnCidade}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Bairro>> listBairrosByCidade(@PathVariable(value = "isnCidade", required = true) Long isnCidade) {
		List<Bairro> list = new ArrayList<Bairro>();
		Iterable<Bairro> itBairros = bairros.findAllByCidade(isnCidade);
		itBairros.forEach(list::add);
		return new ResponseEntity<List<Bairro>>(list, HttpStatus.OK);
	}

}
