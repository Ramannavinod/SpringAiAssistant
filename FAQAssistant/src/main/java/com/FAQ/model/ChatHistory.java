package com.FAQ.model;

public class ChatHistory {
	
	private String question;
	private String answer;
	public ChatHistory(String question, String answer) {
		this.answer=answer;
		this.question=question;
	}
	public String getQuestion() {
		return question;
	}
	public String getAnswer() {
		return answer;
	}
}
