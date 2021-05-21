package Aerothon.prototype.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PageSugesstions")
public class PageSuggestions {

	@Id
	private String pageSuggestionsId;
	private String pageUrl;
	private String suggestion;

	public PageSuggestions() {

	}

	public PageSuggestions(String pageUrl, String suggestions) {
		this.pageUrl = pageUrl;
		this.suggestion = suggestions;
	}

	public String getPageSuggestionsId() {
		return pageSuggestionsId;
	}

	public void setPageSuggestionsId(String pageSuggestionsId) {
		this.pageSuggestionsId = pageSuggestionsId;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getSuggestions() {
		return suggestion;
	}

	public void setSuggestions(String suggestions) {
		this.suggestion = suggestions;
	}

	@Override
	public String toString() {
		return "PageSuggestions [pageSuggestionsId=" + pageSuggestionsId + ", pageUrl=" + pageUrl + ", suggestions="
				+ suggestion + "]";
	}

}
