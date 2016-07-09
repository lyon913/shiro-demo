package com.whr.activiti.web;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestTestClient {
	
	@Test
	public void doRequest(){
		RestTemplate t = new RestTemplate();
		String url = "http://localhost:8080/shiro-demo/xqxapi/rest";
		MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		requestParams.add("api", "test测试");
		requestParams.add("timestamp", "2016-06-17 18:00:00");
		String result = t.postForObject(url, requestParams, String.class);
		System.out.println(result);
		
	}
	
}
