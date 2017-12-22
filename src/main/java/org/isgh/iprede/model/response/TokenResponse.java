package org.isgh.iprede.model.response;

public final class TokenResponse extends AbstractResponse {
	
	private final String token;

	public TokenResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

}
