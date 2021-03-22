package selenium.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		 driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		    driver.get(" https://dev68594.service-now.com/");
//		    WebElement frame = driver.findElementById("gsft_main");
//		    driver.switchTo().frame(frame);
//		    driver.switchTo().frame("gsft_main");
		    driver.switchTo().frame(0);
		    driver.findElementById("user_name").sendKeys("admin");
		    driver.findElementById("user_password").sendKeys("India@123");
		    driver.findElementById("sysverb_login").click();
		    driver.findElementById("filter").sendKeys("incident",Keys.ENTER);
		    Thread.sleep(3000);
		    driver.findElementByXPath("(//div[text()='All'])[2]").click();
		    driver.switchTo().frame("gsft_main");
		    driver.findElementById("sysverb_new").click();
		    driver.findElementById("sys_display.incident.caller_id").sendKeys("Abel Tuter");
		    driver.findElementById("incident.short_description").sendKeys("Hey,Abel Tuter.");
		    String att = driver.findElementByXPath("//input[@id='incident.number']").getAttribute("value");
		    System.out.println(att);
		    Thread.sleep(2000);
		    driver.findElementByXPath("//button[@id='sysverb_insert']").click();
		    driver.findElementByXPath("(//input[@class='form-control'])[1]").sendKeys(att,Keys.ENTER);
		    String num = driver.findElementByXPath("//a[@class='linked formlink']").getText();
		    System.out.println(num);
		    if (att.equals(num)) {
				System.out.println("The incident is verified");
			}
		    else {
		    	System.out.println("The incident is not verified");
			}
		    

	}

}
