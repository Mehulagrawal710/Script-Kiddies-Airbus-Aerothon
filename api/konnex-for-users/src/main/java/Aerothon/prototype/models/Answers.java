package Aerothon.prototype.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Answers")
public class Answers {

	@Id
	private String answerId;

	private String faqId;
	private String userId;
	private String answer;

	public Answers() {

	}

	public Answers(String faqId, String userId, String answer) {

		this.faqId = faqId;
		this.userId = userId;
		this.answer = answer;
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Answers [answerId=" + answerId + ", faqId=" + faqId + ", userId=" + userId + ", answer=" + answer + "]";
	}

}
