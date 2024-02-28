package package1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DM_End_To_End {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("incognito");
//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 String baseUrl = "https://epm-test-stgepmcs.epm.us-ashburn-1.ocs.oc-test.com/epmcloud";
//       
//  
////       
//
//       // launch Fire fox and direct it to the Base URL
       driver.get(baseUrl);
       
       
       driver.findElement(By.xpath("//input[@class='oj-sm-12 oj-form-control oj-inputtext-nocomp']")).sendKeys("epmuser");
       driver.findElement(By.xpath("//input[@class='oj-inputpassword-input oj-component-initnode']")).sendKeys("EPM_Welc0me!");
       driver.findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
       Thread.sleep(100000);
       driver.findElement(By.xpath("//a[@class='oj-flex oj-ux-ico-menu oj-ux-icon-size-6x']")).click();
       
       
       List<WebElement> links = driver.findElement(By.xpath("//div[@class='oj-form oj-enabled oj-efficient oj-form-cols' ]")).findElements(By.tagName("a"));
       int linkscount=links.size();
       System.out.println(linkscount);
       for (WebElement webElement : links) {
       	System.out.println(webElement.getText());
       	String link_to_click="Data Exchange";
       	if (webElement.getText().equals(link_to_click)) 
       	{
				driver.findElement(By.linkText(link_to_click)).click();
				Thread.sleep(100000);
				driver.findElement(By.xpath("(//button[@class='oj-button-button oj-component-initnode'])[2]")).click();
				List<WebElement> DM_Actions_items=driver.findElement(By.xpath("//*[@id='dashboard-action-menu']")).findElements(By.tagName("a"));
				for(WebElement DM_item:DM_Actions_items) {
					String DMLinkText=DM_item.getText();
					System.out.println(DMLinkText);
					
				}
		
       	}
       }

	}

}
