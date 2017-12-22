package org.isgh.iprede.controller;

import java.util.ArrayList;
import java.util.List;

import org.isgh.iprede.model.Regional;
import org.isgh.iprede.repository.Regionais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegionaisController {
	
	@Autowired
	private Regionais regionais;
	
	@GetMapping(value = "/regionais", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Regional>> listRegionais() {
		List<Regional> list = new ArrayList<Regional>();
		Iterable<Regional> itRegionais = regionais.findAll();
		itRegionais.forEach(list::add);
		return new ResponseEntity<List<Regional>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/regionais/findbycidade/{isnCidade}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Regional>> findRegionaisByCidade(@PathVariable(value = "isnCidade", required = true) Long isnCidade) {
		List<Regional> list = new ArrayList<Regional>();
		Iterable<Regional> itBairros = regionais.findAllByCidade(isnCidade);
		itBairros.forEach(list::add);
		return new ResponseEntity<List<Regional>>(list, HttpStatus.OK);
	}

}
