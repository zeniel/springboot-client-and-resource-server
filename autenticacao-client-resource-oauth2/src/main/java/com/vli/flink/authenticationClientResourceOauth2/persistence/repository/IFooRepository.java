package com.vli.flink.authenticationClientResourceOauth2.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.vli.flink.authenticationClientResourceOauth2.persistence.model.Foo;

public interface IFooRepository extends PagingAndSortingRepository<Foo, Long>{

}