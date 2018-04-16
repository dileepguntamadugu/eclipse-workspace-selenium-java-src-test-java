package hybrid.framework;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Report {
	public void takeScreenshot(WebDriver driver) {
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		long pageSize = (Long) jsx.executeScript("return document.body.scrollHeight");
		System.out.println("The pageSize is : "+pageSize);
		if(pageSize<=650) {
			String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
			jsx.executeScript("window.scrollBy(0,1000)","");
			capture(driver,timeStamp,"");
		}
		else if(pageSize>650) {
			String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
			for(int i = 650, j=0;i<pageSize;++i,++j) {
				jsx.executeScript("window.scrollBy("+j+","+i+")", "");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				capture(driver,timeStamp,""+j+"-"+i);
				i=i+649;
				j=j+649;
			}
		}		
	}
	public void capture(WebDriver driver, String timeStamp, String range) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file,new File("C:\\Users\\dilee\\eclipse-workspace\\hybrid.framework\\target\\"
					+ "test-classes\\hybrid\\framework\\Screenshots\\Screenshots"+timeStamp+"scrollRange"+range+".png"));
		} catch (IOException e) {
			System.err.println("There is an exception in taking a screen shot, Please check!!!");
			e.printStackTrace();
		}	
	}
	public void sendMail() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "true");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth","true");Session session = Session.getInstance(props,new javax.mail.Authenticator() 
											{protected PasswordAuthentication getPasswordAuthentication() 
											{return new PasswordAuthentication("dgetme@gmail.com","26263120");}});
		try {
			MimeMessage msg = new MimeMessage(session);
			String to = "kusuma0288@gmail.com,dileep.guntamadugu@gmail.com";
			InternetAddress[] address = InternetAddress.parse(to,true);
			msg.setRecipients(Message.RecipientType.TO, address);
			String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
			msg.setSubject("Sample Mail : "+timeStamp);
			msg.setSentDate(new Date());
			msg.setText("Base Mail to Send reports in Mail");
			msg.setHeader("XPriority","1");
			Transport.send(msg);
			System.out.println("Mail has been sent successfully");
		}catch(MessagingException mex) {
			System.out.println("Unable to send an email"+mex);
		}
	}
}