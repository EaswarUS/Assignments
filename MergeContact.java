package selenium.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws Exception{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementByName("PASSWORD").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
      driver.findElementByLinkText("CRM/SFA").click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.findElementByLinkText("Contacts").click();
      driver.findElementByXPath("(//div[@class='frameSectionBody']//a)[4]").click();
      driver.findElementByXPath("(//img[@alt='Lookup'])[1]").click();
      Set<String> windows= driver.getWindowHandles();
      List<String> toget=new ArrayList<String>(windows);
      driver.switchTo().window(toget.get(1)).manage().window().maximize();
      List<WebElement> tables=driver.findElementsByClassName("x-grid3-row-table");
      WebElement rows= tables.get(1);
      List<WebElement> data=rows.findElements(By.tagName("td"));
      data.get(0).findElement(By.tagName("a")).click();
      driver.switchTo().window(toget.get(0));
      driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
      Set<String> windows2= driver.getWindowHandles();
      List<String> toget2=new ArrayList<String>(windows2);
      driver.switchTo().window(toget2.get(1)).manage().window().maximize();
      List<WebElement> table2=driver.findElementsByClassName("x-grid3-row-table");
      WebElement row2= table2.get(2);
      List<WebElement> data2=row2.findElements(By.tagName("td"));
      data2.get(0).findElement(By.tagName("a")).click();
      driver.switchTo().window(toget.get(0));
      driver.findElementByXPath("//a[text()='Merge']").click();
      Alert alert=driver.switchTo().alert();
      alert.accept();
      Thread.sleep(10000);
      if(driver.getTitle().equals("View Contact | opentaps CRM"));
      {
      	System.out.println(driver.getTitle());
      }
      driver.close();
	}

}
