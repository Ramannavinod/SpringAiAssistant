package com.FAQ.model;

import jakarta.validation.constraints.NotBlank;

public class AskRequest {
	
	@NotBlank
	private String userid;
	@NotBlank
	private String question;
	
	public String getUserid() {
		return userid;
	}

    public String getQuestion() {
		return question;
	}

	

	
	

}
