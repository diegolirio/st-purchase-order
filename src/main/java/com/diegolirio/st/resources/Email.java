package com.diegolirio.st.resources;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
public class Email {

	@Getter
	private String subject, body;
	
	@Getter
	private List<String> to, cc, co, attachments;
	
}
