package Aerothon.prototype.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Company")
public class Company {

	@Id
	private String companyId;
	private String pageUrl;
	private String password;

	public Company() {

	}

	public Company(String pageUrl, String password) {
		this.pageUrl = pageUrl;
		this.password = password;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", pageUrl=" + pageUrl + ", password=" + password + "]";
	}

}
