package com.video.model;

import java.io.Serializable;

public class JSONResults implements Serializable {

	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	private Object obj;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
