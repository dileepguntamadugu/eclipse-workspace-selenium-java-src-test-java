package hybrid.framework;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Main {
	public static void main(String args[]) throws InvalidFormatException, IOException {
		/*RestAssuredTest ra = new RestAssuredTest();
		//To submit a Rest Request with a given set of parameters
		//ra.postGetRequest("https://jsonplaceholder.typicode.com/posts","/1");
		//To validate if the response is received properly
		String value = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
		ra.validateJsonResponse(ra.restGetRequest("https://jsonplaceholder.typicode.com/posts","/1"), "userId", "q");*/
		//WebPageAccess wpa = new WebPageAccess();
		//Report report = new Report();
		//report.takeScreenshot(wpa.openWebPage("https://dzone.com/", "fire"));
		//report.sendMail();
		WriteToExcel write = new WriteToExcel();
		write.establishConnection();
	}
}