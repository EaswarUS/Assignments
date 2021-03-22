package selenium.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnListBoxes {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		WebElement dd1 = driver.findElementById("dropdown1");
		Select index = new Select(dd1);
		index.selectByIndex(1);
		
		WebElement dd2 = driver.findElementByName("dropdown2");
		Select text = new Select(dd2);
		text.selectByVisibleText("Selenium");
		
		WebElement dd3 = driver.findElementById("dropdown3");
		Select value = new Select(dd3);
		value.selectByValue("1");
		
		List<WebElement> dd4 = driver.findElementsByXPath("//select[@class='dropdown']/option");
		System.out.println(dd4.size());
		
		driver.findElementByXPath("//div[@id='contentblock']/section[1]/div[5]/select[1]").sendKeys("Selenium");
		
		Actions builder = new Actions(driver);
		
	WebElement sel = driver.findElementByXPath("(//option[text()='Selenium'])[6]");
	WebElement app = driver.findElementByXPath("(//option[text()='Appium'])[6]");
	WebElement lr = driver.findElementByXPath("(//option[text()='Loadrunner'])[6]");
	
	builder.keyDown(Keys.CONTROL).click(sel).click(app).click(lr).keyUp(Keys.CONTROL).perform();
		
		
		
		
	}

}
