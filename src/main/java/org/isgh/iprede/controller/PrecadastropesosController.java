package org.isgh.iprede.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.isgh.iprede.model.Precadastropeso;
import org.isgh.iprede.repository.Precadastropesos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrecadastropesosController extends AbstractController {
	
	@Autowired
	private Precadastropesos precadastropesos;
	
	@GetMapping(value = "/precadastropesos/findbyprecadastro/{isnPrecadastro}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Precadastropeso>> findPrecadastropesosByPrecadastro(@PathVariable("isnPrecadastro") Long isnPrecadastro) {
		List<Precadastropeso> list = new ArrayList<Precadastropeso>();
		Iterable<Precadastropeso> itPrecadastropesos = precadastropesos.findAllByPrecadastro(isnPrecadastro);
		itPrecadastropesos.forEach(list::add);
		return new ResponseEntity<List<Precadastropeso>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value = "/precadastropesos/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Precadastropeso> savePrecadastropeso(@Valid @RequestBody(required = true) Precadastropeso precadastropeso) {
		precadastropeso.setDatCadastro(new Date());
		precadastropesos.save(precadastropeso);
		return new ResponseEntity<Precadastropeso>(precadastropeso, HttpStatus.OK);
	}

	@GetMapping(value = "/precadastropesos/edit/{isnPrecadastropeso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Precadastropeso> editPrecadastropeso(@PathVariable(value = "isnPrecadastropeso", required = true) long isnPrecadastropeso) {
		Precadastropeso precadastropeso = precadastropesos.findOne(isnPrecadastropeso);
		return new ResponseEntity<Precadastropeso>(precadastropeso, HttpStatus.OK);
	}

}
