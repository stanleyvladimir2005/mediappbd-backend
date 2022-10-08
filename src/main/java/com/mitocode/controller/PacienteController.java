package com.mitocode.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.mitocode.exceptions.ModelNotFoundException;
import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;

@RestController
@RequestMapping("/v1/pacientes")
public class PacienteController {
	
	@Autowired
	private IPacienteService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Paciente>> listar() {
		List<Paciente> pacientes = service.listar();
		return new ResponseEntity<>(pacientes, HttpStatus.OK); //ResponseEntity<List<Paciente>>
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody Paciente paciente) {
		Paciente pac = service.registrar(paciente);
		URI location = ServletUriComponentsBuilder
				          .fromCurrentRequest().path("/{id}")
					      .buildAndExpand(pac.getIdPaciente()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody Paciente paciente) {		
		service.modificar(paciente);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Paciente pac = service.listarPorId(id);
		if (pac == null) 
			throw new ModelNotFoundException("ID: " + id);
		else 
			service.eliminar(id);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EntityModel<Paciente> listarId(@PathVariable("id") Integer id) {
		Paciente paciente = service.listarPorId(id);
		if (paciente == null) 
			throw new ModelNotFoundException("ID: " + id);	
		
		EntityModel<Paciente> entityModel = EntityModel.of(paciente);
		Link link= WebMvcLinkBuilder
				     .linkTo(methodOn(this.getClass()).listar())
				     .withRel("all-users");
		entityModel.add(link);
		return entityModel;
	}
	
	@GetMapping(value="/pageablePaciente", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Paciente>> listarPageable(Pageable pageable) {
		Page<Paciente> pacientes = service.listarPageable(pageable);
		return new ResponseEntity<>(pacientes, HttpStatus.OK);
	}
}