package com.muse.support;

import java.io.Serializable;

public class ReturnResult<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int code;
	
	private String msg;
	
	private T datas;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getDatas() {
		return datas;
	}

	public void setDatas(T datas) {
		this.datas = datas;
	}

	@Override
	public String toString() {
		return "ReturnResult [code=" + code + ", msg=" + msg + ", datas=" + datas + "]";
	}
	

}
