package org.isgh.iprede.controller;

import java.util.ArrayList;
import java.util.List;

import org.isgh.iprede.model.Parentesco;
import org.isgh.iprede.repository.Parentescos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParentescosController {
	
	@Autowired
	private Parentescos parentescos;
	
	@GetMapping(value = "/parentescos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Parentesco>> listParentescos() {
		List<Parentesco> list = new ArrayList<Parentesco>();
		Iterable<Parentesco> itParentescos = parentescos.findAll();
		itParentescos.forEach(list::add);
		return new ResponseEntity<List<Parentesco>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/parentescos/findbyflgativo/{flgAtivo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Parentesco>> findParentescosByFlgAtivo(@PathVariable(value = "flgAtivo", required = true) boolean flgAtivo) {
		List<Parentesco> list = new ArrayList<Parentesco>();
		Iterable<Parentesco> itParentescos = parentescos.findParentescosByFlgAtivo(flgAtivo);
		itParentescos.forEach(list::add);
		return new ResponseEntity<List<Parentesco>>(list, HttpStatus.OK);
	}

}
