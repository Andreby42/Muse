package com.muse.support;
/**
 * 限流异常类
 * @author andreby
 *
 */
public class RequestLimitException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RequestLimitException() {
		super("HTTP请求超出设定的限制");
	}

	@Override
	public StackTraceElement[] getStackTrace() {
		return super.getStackTrace();
	}

}
