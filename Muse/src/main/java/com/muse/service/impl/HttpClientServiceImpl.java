package com.muse.service.impl;

import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.muse.httpclient.HttpClientPool;
import com.muse.httpclient.HttpClientUtil;
import com.muse.httpclient.HttpConfig;
import com.muse.httpclient.HttpMethods;
import com.muse.httpclient.HttpProcessException;
import com.muse.httpclient.PoolEnum;
import com.muse.service.HttpClientService;
import com.muse.support.Utils;

@Component("httpClientService")
public class HttpClientServiceImpl implements HttpClientService {

	@Override
	public String doGet(String url, Map<String, String> params) throws HttpProcessException, URISyntaxException {
		HttpConfig config = HttpConfig.custom();
		config.method(HttpMethods.GET);
		config.outenc("UTF-8");
		config.inenc("UTF-8");
		HttpClientPool pool = PoolEnum.POOL.getInstance();
		config.httpClientPool(pool);
		config.client(pool.build());
		url = Utils.buildUrl(url, params);
		config.url(url);
		return HttpClientUtil.get(config);
	}

}
