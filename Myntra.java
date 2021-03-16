package selenium.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		 driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		    driver.get("https://www.myntra.com/");
		    WebElement womens = driver.findElementByXPath("(//a[text()='Women'][1])");
		    Actions builder = new Actions(driver);
		    builder.moveToElement(womens).perform();
		    
		    driver.findElementByXPath("(//a[text()='Jackets & Coats'])").click();
		    String text = driver.findElementByXPath("//span[@class='title-count']").getText();
		    String replaceAll = text.replaceAll("\\D","");
		    System.out.println("The total count of item="+ replaceAll);
		    int overall = Integer.parseInt(replaceAll);
		    
		    String jackets = driver.findElementByXPath("(//span[@class='categories-num'])[1]").getText();
		    String replaceAll2 = jackets.replaceAll("\\D", "");
		    int add1 = Integer.parseInt( replaceAll2);
		    
		    String coats = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
		    String replaceAll3 = coats.replaceAll("\\D", "");
		    int add2 = Integer.parseInt( replaceAll3);
		    
		   int count = add1 + add2;
		   System.out.println(count);
		   
		   if (count==overall) {
			   System.out.println(" The sum of categories count matches");
			
		}
		   else {
			   System.out.println("The sum of categories count doesn't matches");
		    
	}
		   driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
		   driver.findElementByXPath("//div[@class='brand-more']").click();
		   driver.findElementByXPath("//input[@class='FilterDirectory-searchInput']").sendKeys("Mango");
		   driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[11]").click();
		   driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		   
		   List<WebElement> mango = driver.findElementsByXPath("//h3[text()='MANGO']");
		   
		   for (WebElement list : mango) {
			   System.out.println(list.getText());
			
		}
		   
		   
		   WebElement sort = driver.findElementByXPath("//div[@class='sort-sortBy']");
		   builder.moveToElement(sort).perform();
		   driver.findElementByXPath("//label[text()='Better Discount']").click();
		   List<WebElement> cost = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
		   String price = cost.get(0).getText();
		   System.out.println("The price is =" +price);
		   
		  
		   WebElement size = driver.findElementByXPath("(//img[@class='img-responsive'])[1]");
		   builder.moveToElement(size).perform();
		   driver.findElementByXPath("(//span[@class='product-wishlistFlex product-actionsButton product-wishlist '])[1]").click();
		   driver.close();
		   
		   
		   
		   

}
}
