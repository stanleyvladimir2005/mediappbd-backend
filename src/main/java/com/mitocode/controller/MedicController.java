package com.mitocode.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.OK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.hateoas.EntityModel;
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
import com.mitocode.model.Medic;
import com.mitocode.service.IMedicService;

@RestController
@RequestMapping("/v1/medics")
public class MedicController {
	
	@Autowired
	private IMedicService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Medic>> findAll() {
		List<Medic> medics = service.findAll();
		return new ResponseEntity<>(medics, OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody Medic Medic) {
		Medic med = service.save(Medic);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(med.getIdMedic()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Medic> update(@PathVariable ("id") Integer id,@Valid @RequestBody Medic medic) {
		medic.setIdMedic(id);
		Medic med = service.update(medic, id);
		return new ResponseEntity<>(med,OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return new ResponseEntity<>(OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Medic> findById(@PathVariable("id") Integer id) {
		Medic medic = service.findById(id);
	    return new ResponseEntity<>(medic, OK);
	}
	
	@GetMapping(value="/pageableMedic", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Medic>> listPageable(Pageable pageable) {
		Page<Medic> Medicos = service.listPageable(pageable);
		return new ResponseEntity<>(Medicos, HttpStatus.OK);
	}

	@GetMapping("/hateoas/{id}")
	public EntityModel<Medic> findByIdHateoas(@PathVariable("id") Integer id) {
		Medic med = service.findById(id);
		EntityModel<Medic> resource = EntityModel.of(med);
		WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).findById(id));
		WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).findAll());
		resource.add(link1.withRel("medic-info1"));
		resource.add(link2.withRel("medic-full"));
		return resource;
	}
}