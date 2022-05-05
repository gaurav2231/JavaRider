package com.gaurav.Entity;


import java.util.List;

public class ErrorResponse {

	private List<ErrorDetails> errors;

    public static class ErrorDetails {
    	
        private String fieldName;
        private String message;
       // private int code;
		//private int statuscode;
		
       
        
		public ErrorDetails() {
			super();
		}
		public ErrorDetails(String fieldName, String message) {
			super();
			this.fieldName = fieldName;
			this.message = message;
		}
		public String getFieldName() {
			return fieldName;
		}
		public String getMessage() {
			return message;
		}
		public void setFieldName(String field) {
			this.fieldName = field;
		}
		public void setMessage(String defaultMessage) {
			this.message = defaultMessage;
		}
    }

    
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ErrorResponse(List<ErrorDetails> errors) {
		super();
		this.errors = errors;
	}


	public List<ErrorDetails> getErrors() {
		return errors;
	}


	public void setErrors(List<ErrorDetails> errorDetails) {
		this.errors = errorDetails;
		
	}
}


