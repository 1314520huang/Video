package com.video.model;

import java.io.Serializable;

import com.video.util.ErrorCode;

public class AjaxResponse implements Serializable {
	
	private static final long serialVersionUID = -228336292076840249L;
	private int code = ErrorCode.SUCCESS;
	private String message = "²Ù×÷³É¹¦£¡";
	
	private Object data;
	
	public AjaxResponse() {
		super();
	}
	public AjaxResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public AjaxResponse(Object data) {
		super();
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
