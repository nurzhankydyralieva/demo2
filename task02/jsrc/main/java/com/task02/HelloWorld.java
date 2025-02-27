package com.task02;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.syndicate.deployment.annotations.lambda.LambdaHandler;
import com.syndicate.deployment.model.RetentionSetting;

import java.util.HashMap;
import java.util.Map;

@LambdaHandler(lambdaName = "hello_world",
		roleName = "hello_world-role",
		isPublishVersion = false,
		logsExpiration = RetentionSetting.SYNDICATE_ALIASES_SPECIFIED
)

public class HelloWorld implements RequestHandler<Object, Map<String, Object>> {

	public Map<String, Object> handleRequest(Object request, Context context) {
		System.out.println("Hello from lambda");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ("/hello".equals(request)) {
			resultMap.put("statusCode", 200);
			resultMap.put("message", "Hello from Lambda");
			return resultMap;
		} else {
			resultMap.put("statusCode", 404);
			resultMap.put("message", "Bad request syntax or unsupported method. Request path: {path}. HTTP method: {method}");
			return resultMap;
		}
	}
}
