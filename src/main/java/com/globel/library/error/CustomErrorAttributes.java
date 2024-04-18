package com.globel.library.error;

import java.util.Arrays;
import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

	
	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
		
		Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
		
		
		// custom body for return error or status
		errorAttributes.put("local", webRequest.getLocale().toString());
		errorAttributes.put("success", Boolean.FALSE);
		errorAttributes.put("status", errorAttributes.get("error"));
		errorAttributes.put("exception", errorAttributes.get("message"));
		errorAttributes.put("details", Arrays.asList(errorAttributes.get("message")));
		errorAttributes.remove("error"); // remove spcif key
		errorAttributes.remove("path");

		
		return errorAttributes;
	}
}
