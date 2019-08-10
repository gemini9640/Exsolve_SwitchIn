package com.exl_si.exception;

import java.io.IOException;

public class UploadException extends Exception {
	private static final long serialVersionUID = 8669403950171336285L;
	private String message;  
	private String path;
	private IOException ioe; 


	public UploadException(String message) {
		this.message = message;
	}
	
	public UploadException(IOException ioe, String path) {
		this.ioe = ioe;
		this.message = ioe.getMessage();
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public IOException getIoe() {
		return ioe;
	}

	public void setIoe(IOException ioe) {
		this.ioe = ioe;
	}
	
}
