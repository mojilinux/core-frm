package com.core.framework.config.security.jwt;

public class JwtResponse {
	private String jwtToken;

	public JwtResponse(String jwt) {
		this.jwtToken = jwt;
	}

	public String getJwtToken() {

		return jwtToken;
	}

	public JwtResponse setJwtToken(String jwtToken) {

		this.jwtToken = jwtToken;
		return this;
	}
}
