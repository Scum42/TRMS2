package com.revature.util;

public class JsonResult {
	public static String getResult(boolean success) {
		return "{\"success\":" + success + "}";
	}
}
