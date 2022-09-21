package com.mitocode.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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

import com.mitocode.dto.exceptions.ModelNotFoundException;
import com.mitocode.model.Especialidad;
import com.mitocode.service.IEspecialidadService;

@RestController
@RequestMapping("/v1/especialidades")
public class EspecialidadController {
	
	@Autowired
	private IEspecialidadService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Especialidad>> listar() {
		List<Especialidad> especialidades = service.listar();
		return new ResponseEntity<>(especialidades, HttpStatus.OK);
	}
		
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody Especialidad Especialidad) {
		Especialidad esp = service.registrar(Especialidad);
		URI location = ServletUriComponentsBuilder
				         .fromCurrentRequest()
				         .path("/{id}")
					     .buildAndExpand(esp.getIdEspecialidad())
				         .toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody Especialidad Especialidad) {		
		service.modificar(Especialidad);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Especialidad pac = service.listarPorId(id);
		if (pac == null) 
			throw new ModelNotFoundException("ID: " + id);
		else 
			service.eliminar(id);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EntityModel<Especialidad> listarId(@PathVariable("id") Integer id) {
		Especialidad Especialidad = service.listarPorId(id);
		if (Especialidad == null) 
			throw new ModelNotFoundException("ID: " + id);	
		
		EntityModel<Especialidad> entityModel = EntityModel.of(Especialidad);
		Link link= WebMvcLinkBuilder
				    .linkTo(methodOn(this.getClass()).listar())
				    .withRel("all-users");
		entityModel.add(link);
		return entityModel;
	}
	
	@GetMapping(value="/pageableEspecialidad", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Especialidad>> listarPageable(Pageable pageable) {
		Page<Especialidad> especialidad = service.listarPageable(pageable);
		return new ResponseEntity<>(especialidad, HttpStatus.OK);
	}
}