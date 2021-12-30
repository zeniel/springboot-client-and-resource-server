package com.vli.flink.authenticationClientResourceOauth2.dto;

public class FooDTO {
	
	private final long id;
	private final String name;
	
	public FooDTO(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}