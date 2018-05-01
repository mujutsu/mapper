package com.syneco.mapper.model;

public class Response {

	private final Long id;
	private final String responseCode;

	public Response(Long id, String responseCode) {
		this.id = id;
		this.responseCode = responseCode;
	}

	public Long getId() {
		return id;
	}

	public String getResponseCode() {
		return responseCode;
	}

}
