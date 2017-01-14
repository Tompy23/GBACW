package com.tompy.threedog;

public class CommandReturn 
{
	private Boolean directive;
	private String message;
	private String prompt;
//	private GAME_STATUS status;
	
	public CommandReturn()
	{
		directive = true;
		message = "No message";
		prompt = "EmptyGame>";
//		status = GAME_STATUS.NOT_STARTED;
	}
	
	public CommandReturn( String message )
	{
		directive = true;
		this.message = message;
		prompt = null;
//		status = null;
	}
	
	public Boolean isDirective() {
		return directive;
	}
	public void setDirective(Boolean directive) {
		this.directive = directive;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

//	public GAME_STATUS getStatus() {
//		return status;
//	}
//
//	public void setStatus(GAME_STATUS status) {
//		this.status = status;
//	}
	
}
