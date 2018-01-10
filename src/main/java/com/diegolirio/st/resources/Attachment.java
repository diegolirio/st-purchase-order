package com.diegolirio.st.resources;

import com.sun.mail.util.BASE64DecoderStream;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {

	private String name, fileBase64;
	
	public byte[] getFileBinary() {
		byte[] bytes = fileBase64.getBytes();
		return BASE64DecoderStream.decode(bytes);		
	}
	
}
