package Aerothon.prototype.dtos;

public class GetAnswerDTO {

	private String faqId;

	public GetAnswerDTO(String faqId) {
		this.faqId = faqId;
	}

	public String getFaqId() {
		return faqId;
	}

	public void setFaqId(String faqId) {
		this.faqId = faqId;
	}

	@Override
	public String toString() {
		return "GetAnswerDTO [faqId=" + faqId + "]";
	}

}
