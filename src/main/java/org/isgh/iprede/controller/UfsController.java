package org.isgh.iprede.controller;

import java.util.ArrayList;
import java.util.List;

import org.isgh.iprede.model.Uf;
import org.isgh.iprede.repository.Ufs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UfsController {

	@Autowired
	private Ufs ufs;
	
	@GetMapping(value = "/ufs", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Uf>> listUfs() {
		List<Uf> list = new ArrayList<Uf>();
		Iterable<Uf> itUfs = ufs.findAll();
		itUfs.forEach(list::add);
		return new ResponseEntity<List<Uf>>(list, HttpStatus.OK);
	}

}
