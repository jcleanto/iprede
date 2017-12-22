package org.isgh.iprede.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.isgh.iprede.model.Precadastro;
import org.isgh.iprede.repository.Precadastros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Transactional
@RestController
public class PrecadastrosController extends AbstractController {

	@Autowired
	private Precadastros precadastros;
	
	@PostMapping(value = "/precadastros/find", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Precadastro>> findPrecadastrosByName(@RequestBody(required = true) Precadastro precadastro) {
		List<Precadastro> list = new ArrayList<Precadastro>();
		String nome = (precadastro.getDscNome() != null && !precadastro.getDscNome().isEmpty())?precadastro.getDscNome().toUpperCase():"";
		Iterable<Precadastro> itPrecadastros = precadastros.findByDscnomeOrDscNomeSocial(nome);
		itPrecadastros.forEach(list::add);
		return new ResponseEntity<List<Precadastro>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value = "/precadastros/findwithprecadastropeso", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Precadastro>> findWithPrecadastropeso(@RequestBody(required = true) Precadastro precadastro) {
		List<Precadastro> list = new ArrayList<Precadastro>();
		String nome = (precadastro.getDscNome() != null && !precadastro.getDscNome().isEmpty())?precadastro.getDscNome().toUpperCase():"";
		Iterable<Precadastro> itPrecadastros = precadastros.findWithPrecadastropeso(nome);
		itPrecadastros.forEach(list::add);
		return new ResponseEntity<List<Precadastro>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/precadastros/findallwithprecadastropeso", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Precadastro>> findAllWithPrecadastropeso() {
		List<Precadastro> list = new ArrayList<Precadastro>();
		Iterable<Precadastro> itPrecadastros = precadastros.findAllWithPrecadastropeso();
		itPrecadastros.forEach(list::add);
		return new ResponseEntity<List<Precadastro>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value = "/precadastros/findwithoutprecadastropeso", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Precadastro>> findWithoutPrecadastropeso(@RequestBody(required = true) Precadastro precadastro) {
		List<Precadastro> list = new ArrayList<Precadastro>();
		String nome = (precadastro.getDscNome() != null && !precadastro.getDscNome().isEmpty())?precadastro.getDscNome().toUpperCase():"";
		Iterable<Precadastro> itPrecadastros = precadastros.findWithoutPrecadastropeso(nome);
		itPrecadastros.forEach(list::add);
		for (Precadastro precadastro1 : list) {
			precadastro1.setListPrecadastropeso(null);
		}
		return new ResponseEntity<List<Precadastro>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/precadastros/findallwithoutprecadastropeso", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Precadastro>> findAllWithoutPrecadastropeso() {
		List<Precadastro> list = new ArrayList<Precadastro>();
		Iterable<Precadastro> itPrecadastros = precadastros.findAllWithoutPrecadastropeso();
		itPrecadastros.forEach(list::add);
		for (Precadastro precadastro : list) {
			precadastro.setListPrecadastropeso(null);
		}
		return new ResponseEntity<List<Precadastro>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/precadastros/findacceptedwhoanthro", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Precadastro>> findAcceptedWhoAnthro() {
		List<Precadastro> list = new ArrayList<Precadastro>();
		List<Precadastro> listTemp = precadastros.findAcceptedWhoAnthro();
		listTemp.size();
		for (Precadastro precadastro : listTemp) {
			precadastro.setUfCuidador(null);
		}
		Iterable<Precadastro> itPrecadastros = listTemp;
		itPrecadastros.forEach(list::add);
		return new ResponseEntity<List<Precadastro>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/precadastros/findrejectedwhoanthro", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Precadastro>> findRejectedWhoAnthro() {
		List<Precadastro> list = new ArrayList<Precadastro>();
		Iterable<Precadastro> itPrecadastros = precadastros.findRejectedWhoAnthro();
		itPrecadastros.forEach(list::add);
		return new ResponseEntity<List<Precadastro>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/precadastros/findforwarded", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Precadastro>> findForwarded() {
		List<Precadastro> list = new ArrayList<Precadastro>();
		Iterable<Precadastro> itPrecadastros = precadastros.findForwarded();
		itPrecadastros.forEach(list::add);
		return new ResponseEntity<List<Precadastro>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value = "/precadastros/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Precadastro> savePrecadastro(@Valid @RequestBody(required = true) Precadastro precadastro) {
		precadastro.setDatCadastro(new Date());
		precadastros.save(precadastro);
		return new ResponseEntity<Precadastro>(precadastro, HttpStatus.OK);
	}

	@GetMapping(value = "/precadastros/edit/{isnPrecadastro}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Precadastro> editPrecadastro(@PathVariable(value = "isnPrecadastro", required = true) long isnPrecadastro) {
		Precadastro precadastro = precadastros.findPrecadastroById(isnPrecadastro);
		return new ResponseEntity<Precadastro>(precadastro, HttpStatus.OK);
	}

}
