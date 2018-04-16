package hybrid.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebPageAccess {
	private WebDriver driver;
	
	public WebDriver openWebPage(String webpage, String driverName) {
		//Creating a Chrome driver object
		if(driverName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","E:\\Learnings\\Automation\\Library\\chromedriver.exe");
			driver = new ChromeDriver();
		}//Creating a Firefox driver object
		else if (driverName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","E:\\Learnings\\Automation\\Library\\geckodriver.exe");
			driver= new FirefoxDriver();
		}//Creating IE as a Default driver
		else {
			System.setProperty("webdriver.ie.driver", "E:\\Learnings\\Automation\\Library\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();	
		}
		maximizeWindow();
		driver.get(webpage);
		return driver;
	}
	public WebDriver maximizeWindow() {
		driver.manage().window().maximize();
		return driver;
	}
}