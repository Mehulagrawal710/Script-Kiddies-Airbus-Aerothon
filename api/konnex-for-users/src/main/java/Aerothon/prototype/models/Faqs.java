package Aerothon.prototype.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import org.springframework.data.elasticsearch.annotations.Document;

//@Document(indexName = "faqs", createIndex = true)
@Document(collection = "faqs")
public class Faqs {

	@Id
	private String faqId;

	private String userId;
	private String pageUrl;
	private String question;

	public Faqs() {

	}

	public Faqs(String userId, String pageUrl, String question) {
		this.userId = userId;
		this.pageUrl = pageUrl;
		this.question = question;
	}

	public String getFaqId() {
		return faqId;
	}

	public void setFaqId(String faqId) {
		this.faqId = faqId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Faqs [faqId=" + faqId + ", userId=" + userId + ", pageUrl=" + pageUrl + ", question=" + question + "]";
	}

}
