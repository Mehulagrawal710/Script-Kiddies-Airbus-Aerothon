package Aerothon.prototype.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tokens")
public class Tokens {

	@Id
	private String tokenId;

	private String userId;
	private String token;

	public Tokens() {

	}

	public Tokens(String userId, String token) {
		this.userId = userId;
		this.token = token;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Tokens [tokenId=" + tokenId + ", userId=" + userId + ", token=" + token + "]";
	}

}
