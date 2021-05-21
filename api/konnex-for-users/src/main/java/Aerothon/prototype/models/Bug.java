package Aerothon.prototype.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Bug")
public class Bug {

	@Id
	private String bugId;
	private String pageUrl;
	private String bug;

	public Bug() {
	}

	public Bug(String bugId, String pageUrl, String bug) {
		this.bugId = bugId;
		this.pageUrl = pageUrl;
		this.bug = bug;
	}

	public String getBugId() {
		return bugId;
	}

	public void setBugId(String bugId) {
		this.bugId = bugId;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getBug() {
		return bug;
	}

	public void setBug(String bug) {
		this.bug = bug;
	}

	@Override
	public String toString() {
		return "Bug [bugId=" + bugId + ", pageUrl=" + pageUrl + ", bug=" + bug + "]";
	}

}
