package com.muse.httpclient;

public enum PoolEnum {
	POOL;
	private HttpClientPool pool;

	PoolEnum() {
		try {
			pool = (HttpClientPool) HttpClientPool.custom().pool(10, 10).retry(3).timeout(6000)
					.setMaxConnPerRoute(1000);
		} catch (HttpProcessException e) {
			e.printStackTrace();
		}
	}

	public HttpClientPool getInstance() {
		return pool;

	}
}
