package applications;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementLibraries {
	private HashMap<String, ElementActionType> elmnt = new HashMap<>();
	private WebElement element;
	private By by;
	private Id;
	
	public void qantasBooking() {
		elmnt.put("flights", ElementActionType(element.click(),by.findElement(xPath),"//div[contains(@id,'book-a-trip')]//a[contains(@id,'panel-flights')]"));
	}

}
