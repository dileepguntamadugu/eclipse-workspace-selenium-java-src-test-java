package hybrid.framework;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredTest {
	
	public String restGetRequest(String baseURI, String methodURL) {
		RestAssured.baseURI = baseURI;
		RequestSpecification httpRequest = RestAssured.given();
		System.out.println(httpRequest);
		Response response = httpRequest.get(methodURL);
		String responseBody = response.getBody().asString();
		System.out.println("The response body is "+responseBody);
		return responseBody;
	}
	public String restPostRequest(String baseURI, String methodURL) {
		RestAssured.baseURI = baseURI;
		RequestSpecification httpRequest = RestAssured.given();
		Map<String,String> headers = new HashMap<>();
		headers.put("Content-Type", "application/x-www-form-urlencoded");
		headers.put("Authorization", "Basic zzzzzzzzzzzzzzzzzzz");
		httpRequest.headers(headers);
		String content = "";
		return content;
		
	}
	public boolean validateJSONResponse(String responseBody, String element, String value) {
		if(responseBody.contains(element)) {
			System.out.println("The element "+element+" is found in the request");
			int length = responseBody.indexOf(element)+element.length()+3;
			System.out.println("The substring value is : " +responseBody.substring(length,length+value.length()+1));
			if(value.equalsIgnoreCase(responseBody.substring(length,length+value.length()+1))) {
				System.out.println("The Substring element is : "+value.equalsIgnoreCase(responseBody.substring(length,length+value.length())));
				return true;
			}
			else {
				System.err.println("No Such element found in the response, Please check");
				return false;
			}
		}
		System.err.println("No Such element found in the response, Please check");
		return false;
	}
}