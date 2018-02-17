package com.revature.util;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonUtil {
	private ObjectMapper om = new ObjectMapper();

	public static final String JSON_NULL = "null";

	public String getJsonSuccess(boolean success) {
		return "{\"success\":" + success + "}";
	}

	public String toJson(Object o) throws JsonProcessingException {
		return om.writeValueAsString(o);
	}
}
