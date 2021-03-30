package assesment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get(" https://www.redbus.in/");
		driver.findElementByXPath("//input[@id='src']").sendKeys("C");
		driver.findElementByXPath("//li[text()='Coimbatore (All Locations)']").click();
		driver.findElementByXPath("//input[@id='dest']").sendKeys("K");
		driver.findElementByXPath("//li[text()='Koyambedu, Chennai']").click();
		driver.findElementByXPath("//input[@id='onward_cal']").click();
		driver.findElementByXPath("//td[@class='next']").click();
		driver.findElementByXPath("(//td[@class='wd day'])[1]").click();
		driver.findElementByXPath("//button[text()='Search Buses']").click();
		
		driver.findElementByXPath("//i[@class='icon icon-close c-fs']").click();
		
		String text = driver.findElementByXPath("//span[@class='f-bold busFound']").getText();
		System.out.println("The number of search buses " + text);
		Thread.sleep(2000);
		driver.findElementByXPath("//span[text()='Ok, got it']").click();

		driver.findElementByXPath("(//label[@class='cbox-label'])[6]").click();
		driver.findElementByXPath("(//label[@class='cbox-label'])[7]").click();
		String AC = driver.findElementByXPath("//span[@class='f-bold busFound']").getText();
		System.out.println("The number of search AC buses " + AC);

		List<WebElement> totalList = driver.findElementsByXPath("//div[@class='fare d-block']");
		System.out.println(totalList.size());

		List<Integer> maxValue = new ArrayList<Integer>();

		for (int i = 0; i <= totalList.size() - 1; i++) {

			String rate= totalList.get(i).getText();
			String busFare = rate.replaceAll("[^0-9]", "");
			int travelcharge = Integer.parseInt(busFare);
			maxValue.add(travelcharge);
			// System.out.println(travelFare);
		}

		Collections.sort(maxValue);
		Integer maxcharge = Collections.max(maxValue);
		System.out.println("Maximum Fare: " + maxcharge);

		System.out.println("Costliest bus name:" + driver.findElementByXPath(
				"//*[contains(text(), " + maxcharge + ")]/preceding::div[@class=\"travels lh-24 f-bold d-color\"][1]")
				.getText());
	}

}
