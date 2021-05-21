package Aerothon.prototype.dtos;

public class ResponseMsgDTO {

	private String message;

	public ResponseMsgDTO(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseMsgDTO [message=" + message + "]";
	}

}
