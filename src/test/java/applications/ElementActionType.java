package applications;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementActionType {
	private WebElement element;
	private By by;
	private String elementLocator;
	
	
	public ElementActionType(WebElement element, By by, String elementLocator) {
		this.by=by;
		this.element=element;
		this.elementLocator = elementLocator;
	}
	
	public WebElement getElement() {
		return element;
	}
	
	public By getBy() {
		return by;
	}
	
	public String getElementLocator() {
		return elementLocator;
	}
}
