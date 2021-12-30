package com.vli.flink.authenticationClientResourceOauth2.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.vli.flink.authenticationClientResourceOauth2.persistence.model.Customer;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {

}