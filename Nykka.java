package selenium.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykka {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		 driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		    driver.get("https://www.nykaa.com/");
		    WebElement brands = driver.findElementByXPath("//a[text()='brands']");
		    Actions builder = new Actions(driver);
		    builder.moveToElement(brands).perform();
		    WebElement popular = driver.findElementByXPath("//a[text()='Popular']");
		    builder.moveToElement(popular).perform();
		    driver.findElementByXPath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']").click();
		   
		    
		    Set<String> windowHandles = driver.getWindowHandles();
		    List<String> newwindow = new ArrayList<String>(windowHandles);
		    driver.switchTo().window(newwindow.get(1));
		    String title = driver.getTitle();
		    System.out.println(title);
		    
		    driver.findElementByXPath("//i[@class='fa fa-angle-down']").click();
		    driver.findElementByXPath("(//div[@class='control__indicator radio'])[4]").click();

		    Thread.sleep(5000);
		    driver.findElementByXPath("//div[text()='Category']").click();
		    driver.findElementByXPath("//span[text()='Hair']").click();
		    driver.findElementByXPath("//span[text()='Hair Care']").click();
		    driver.findElementByXPath("//div[@class='control__indicator']").click();
		    String text = driver.findElementByXPath("//li[text()='Shampoo']").getText();
		    String comparingText = text.replaceAll("close", "");
		    
		    if (comparingText.equals("Shampoo")) {
				System.out.println("Filter is Applied");
			}
		    else {
				System.out.println("Filter is Not Applied");
			}
		    
		    driver.findElementByXPath("(//img[@class='listing-img'])[4]").click();
		    
		    Set<String> windowHandles2 = driver.getWindowHandles();
		    List<String> newwindow2 = new ArrayList<String>(windowHandles2);
		    driver.switchTo().window(newwindow2.get(2));
		    
		    driver.findElementByXPath("(//span[@class='size-pallets'])[1]").click();
		    String cost = driver.findElementByXPath("(//span[@class='post-card__content-price-offer'])[1]").getText();
            String mrp = cost.replaceAll("\\D", "");
            System.out.println("The MRP = "+mrp);
            
            driver.findElementByXPath("(//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  '])[1]").click();
		    driver.findElementByXPath("//div[@class='AddBagIcon']").click();
		    String total = driver.findElementByXPath("//div[@class='value medium-strong']").getText();
		    String price = total.replaceAll("\\D", "");
		    System.out.println("The grand total = "+price);
		    Thread.sleep(5000);
		    
		    driver.findElementByXPath("//button[@class='btn full fill no-radius proceed ']").click();
		    
		    driver.findElementByXPath("//button[@class='btn full big']").click();
		    String text2 = driver.findElementByXPath("(//div[@class='value'])[2]").getText();
		    String all = text2.replaceAll("\\D", "");
		    System.out.println(all);
		    if (all.equals(price)) {
				System.out.println("The Grand Total Is Same");
			}
		    else {
		    	System.out.println("The Grand Total Is Not Same");
			}
		    driver.quit();
		    
		    
		    
		    
	}
	
	        
	

}
