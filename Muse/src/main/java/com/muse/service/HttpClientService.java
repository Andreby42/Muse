package com.muse.service;

import java.net.URISyntaxException;
import java.util.Map;

import com.muse.httpclient.HttpProcessException;

public interface HttpClientService {

	String doGet(String url, Map<String, String> params) throws HttpProcessException, URISyntaxException;
}
