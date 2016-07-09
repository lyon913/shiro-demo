package com.whr.activiti.web;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestTestController {
	protected final Logger log = LoggerFactory.getLogger(RestTestController.class);

	@RequestMapping(value = "/xqxapi/rest", method = RequestMethod.POST)
	public @ResponseBody String doPost(
			@RequestParam String api, 
			@RequestParam String timestamp, 
			HttpServletRequest request) throws IOException {
		
		log.debug(request.getHeader("Content-Type"));
		InputStream is = request.getInputStream();
		String body = IOUtils.toString(is, "utf-8");
		log.debug("=== body:" + body);
		log.debug("=== api:" + api);
		log.debug("=== timestamp:" + timestamp);
		return "{sucess:true}";
	}
}
