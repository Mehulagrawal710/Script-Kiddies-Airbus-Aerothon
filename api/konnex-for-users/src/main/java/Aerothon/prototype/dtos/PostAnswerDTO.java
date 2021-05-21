package Aerothon.prototype.dtos;

public class PostAnswerDTO {

	private String faqId;
	private String answer;

	public PostAnswerDTO() {

	}

	public PostAnswerDTO(String faqId, String answer) {
		this.faqId = faqId;
		this.answer = answer;
	}

	public String getFaqId() {
		return faqId;
	}

	public void setFaqId(String faqId) {
		this.faqId = faqId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "PostAnswerDTO [faqId=" + faqId + ", answer=" + answer + "]";
	}

}