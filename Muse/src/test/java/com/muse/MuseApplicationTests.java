package com.muse;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.muse.httpclient.HttpProcessException;
import com.muse.service.HttpClientService;
import com.muse.support.Constants.API;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MuseApplicationTests {
	@Resource
	private HttpClientService httpClientService;

	@Test
	public void contextLoads() throws HttpProcessException, URISyntaxException {
		Map<String, String> map = new HashMap<>();
		map.put("type", "search");
		map.put("search_type", "1");
		map.put("s", "cocoon");
		// https://api.imjad.cn/cloudmusic/?type=search&search_type=1&s=cocoon
		String json = httpClientService.doGet(API.BASE_SEARCH_API, map);
		System.out.println(json);
	}

}
