package com.whr.activiti.utils;

import java.util.UUID;

public class Utils {
	
	public static String getBusinessKey() {
		return UUID.randomUUID().toString();
	}
	
}
