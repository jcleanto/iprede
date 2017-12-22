package org.isgh.iprede.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.isgh.iprede.exception.RestExceptionCode;
import org.isgh.iprede.model.Referencia;
import org.isgh.iprede.model.response.ErrorResponse;
import org.isgh.iprede.repository.Referencias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReferenciasController extends AbstractController {

	@Autowired
	private Referencias referencias;

	@GetMapping(value = "/referencias", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Referencia>> listReferencias() {
		List<Referencia> list = new ArrayList<Referencia>();
		Iterable<Referencia> itReferencias = referencias.findReferencias();
		itReferencias.forEach(list::add);
		return new ResponseEntity<List<Referencia>>(list, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/referenciass", produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<PagedResources<Referencia>> referenciass(Pageable pageable, PagedResourcesAssembler<Referencia> assembler) {
		Page<Referencia> referenciass = referencias.findAll(pageable);
		return new ResponseEntity(assembler.toResource(referenciass), HttpStatus.OK);
	}
	
	@PostMapping(value = "/referencias/find", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Referencia>> findReferenciasByDscReferenciaOrSglReferencia(@RequestBody(required = true) Referencia referencia) {
		String dscReferencia = (referencia.getDscReferencia() != null && !referencia.getDscReferencia().isEmpty())?referencia.getDscReferencia().toUpperCase():"";
		List<Referencia> list = new ArrayList<Referencia>();
		Iterable<Referencia> itReferencias = referencias.findByDscReferenciaOrSglReferencia(dscReferencia);
		itReferencias.forEach(list::add);
		return new ResponseEntity<List<Referencia>>(list, HttpStatus.OK);
	}

	@PostMapping(value = "/referencias/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Referencia> saveReferencia(@Valid @RequestBody(required = true) Referencia referencia) {
		referencia.setDatCadastro(new Date());
		referencias.save(referencia);
		return new ResponseEntity<Referencia>(referencia, HttpStatus.OK);
	}

	@GetMapping(value = "/referencias/edit/{isnReferencia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Referencia> editReferencia(@PathVariable(value = "isnReferencia", required = true) long isnReferencia) {
		Referencia referencia = referencias.findById(isnReferencia);
		return new ResponseEntity<Referencia>(referencia, HttpStatus.OK);
	}
	
    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<Object> handleException(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return new ResponseEntity<>(errors, HttpStatus.OK);
    }*/

}
