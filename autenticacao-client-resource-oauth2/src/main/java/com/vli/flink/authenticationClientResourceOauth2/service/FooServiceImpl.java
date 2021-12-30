package com.vli.flink.authenticationClientResourceOauth2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vli.flink.authenticationClientResourceOauth2.persistence.model.Foo;
import com.vli.flink.authenticationClientResourceOauth2.persistence.repository.IFooRepository;

@Service
public class FooServiceImpl implements IFooService{
	
	@Autowired
	private IFooRepository repository;

	@Override
	public Optional<Foo> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Foo save(Foo foo) {
		return repository.save(foo);
	}

	@Override
	public Iterable<Foo> findAll() {
		return repository.findAll();
	}

}
