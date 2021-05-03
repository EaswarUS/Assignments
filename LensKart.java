package selenium.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LensKart {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.lenskart.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement compGlasses = driver.findElement(By.xpath("//a[text()='Computer Glasses']"));
		Thread.sleep(2000);
		WebElement mensGender = driver.findElement(By.xpath("(//img[@alt='men'])[2]"));
		WebElement premiumRange = driver.findElement(By.xpath("//span[text()='PREMIUM RANGE']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(compGlasses).perform();
		builder.moveToElement(mensGender).perform();
		builder.moveToElement(premiumRange).click().perform();

		driver.findElement(By.xpath("//span[@title='Round']")).click();

		Thread.sleep(2000);
		String countText = driver
				.findElement(By.xpath("(//li[@class='list-checkbox']//label/input)[1]/following-sibling::span"))
				.getText().replaceAll("\\D", "");
		int fetchedFrameCount = Integer.parseInt(countText);
		System.out.println(countText);
		

		Thread.sleep(3000);
		WebElement frameColor = driver.findElement(By.xpath("(//li[@class='list-checkbox']//label/input)[1]"));

		//for scrolling down
		js.executeScript("arguments[0].scrollIntoView();", frameColor);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='FRAME COLOR']/following::span")).click();

		List<WebElement> listOfElemnts = driver.findElements(By.xpath("//div[@class='col-md-12 no-padding text-color-black fw700 margin-b4']"));
		int size = listOfElemnts.size();
		System.out.println(size);
		if (fetchedFrameCount == size) {
			System.out.println("count is Matched");
		}else {
			System.out.println("count is not Matched");
		}
		
		WebElement firstElement = driver.findElement(By.xpath("//img[@class='img-responsive']"));
		builder.moveToElement(firstElement).perform();
		 
		Thread.sleep(3000);
		String sizeOfTheGlass = driver.findElement(By.xpath("(//p[@class='fs12 no-decoration text-black margin-b0 inline-block']/span)[1]")).getText();
	
		
		System.out.println(sizeOfTheGlass);
		
		driver.close();
	}

}
