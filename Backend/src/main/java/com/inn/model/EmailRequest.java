package com.inn.model;

public class EmailRequest {

	private String to;
	private String subject;
	private String message;
	private String attachment;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	@Override
	public String toString() {
		return "EmailRequest [to=" + to + ", subject=" + subject + ", message=" + message + ", attachment=" + attachment
				+ "]";
	}
	public EmailRequest(String to, String subject, String message, String attachment) {
		super();
		this.to = to;
		this.subject = subject;
		this.message = message;
		this.attachment = attachment;
	}
	public EmailRequest() {
		super();
	}

	
	
}
