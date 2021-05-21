package Aerothon.prototype.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserDetails")
public class UserDetails {

	@Id
	private String userId;

	private String username;
	private String password;
	private String email;
	private int totalScore;
	private int noOfQueAnswered;

	public UserDetails() {

	}

	public UserDetails(String username, String password, String email, int totalScore, int noOfQueAnswered) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.totalScore = totalScore;
		this.noOfQueAnswered = noOfQueAnswered;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getNoOfQueAnswered() {
		return noOfQueAnswered;
	}

	public void setNoOfQueAnswered(int noOfQueAnswered) {
		this.noOfQueAnswered = noOfQueAnswered;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", username=" + username + ", password=" + password + ", email="
				+ email + ", totalScore=" + totalScore + ", noOfQueAnswered=" + noOfQueAnswered + "]";
	}

}
