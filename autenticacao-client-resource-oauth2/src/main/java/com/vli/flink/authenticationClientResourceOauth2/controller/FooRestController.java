package com.vli.flink.authenticationClientResourceOauth2.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vli.flink.authenticationClientResourceOauth2.dto.FooDTO;
import com.vli.flink.authenticationClientResourceOauth2.persistence.model.Foo;
import com.vli.flink.authenticationClientResourceOauth2.service.IFooService;

@RestController
@RequestMapping(value = "/api/foos")
public class FooRestController {
	
	@Autowired
	private IFooService fooService;
	
	@GetMapping(value = "/{id}")
	public FooDTO findOne(@PathVariable Long id) {
		Foo entity = fooService.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return convertToDTO(entity);
	}
	
	@GetMapping(value = "")
	public Collection<FooDTO> findAll(){
		Iterable<Foo> foos = fooService.findAll();
		List<FooDTO> fooDTOs = new ArrayList<>();
		
		foos.forEach(e -> fooDTOs.add(convertToDTO(e)));
		
		return fooDTOs;
	}
	
	private FooDTO convertToDTO(Foo entity) {
		return new FooDTO(entity.getId(), entity.getName());
	}
}
