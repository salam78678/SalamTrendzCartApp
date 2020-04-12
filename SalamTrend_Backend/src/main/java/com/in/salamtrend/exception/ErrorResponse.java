package com.in.salamtrend.exception;

import java.util.Date;

public class ErrorResponse {
	private String msg;
	private Date timeStamp;
	private String details;
	public ErrorResponse(String msg, Date timeStamp, String details) {
		super();
		this.msg = msg;
		this.timeStamp = timeStamp;
		this.details = details;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}


}
