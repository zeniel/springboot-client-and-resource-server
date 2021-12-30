package com.vli.flink.authenticationClientResourceOauth2.service;

import java.util.Optional;

import com.vli.flink.authenticationClientResourceOauth2.persistence.model.Foo;

public interface IFooService {
	Optional<Foo> findById(Long id);
	
	Foo save(Foo foo);
	
	Iterable<Foo> findAll();
}
