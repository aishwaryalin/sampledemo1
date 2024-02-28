package package1;

import java.util.Iterator;
//import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

public class Day1class {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
//		 driver = new ChromeDriver();
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("incognito");
//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String SiteUrl="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(SiteUrl);
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		List<WebElement> links= driver.findElements(By.tagName("a"));
		for(WebElement web: links)
		{
			
			if(!web.getText().isEmpty()) {
				System.out.println(web.getText());
			}
		}
		
		String searchitem="P";
		Boolean result=false;
		driver.findElement(By.xpath("//*[@class='oxd-input oxd-input--active']")).sendKeys(searchitem);

		List<WebElement> searchitems = driver.findElement(By.className("oxd-sidepanel-body")).findElements(By.tagName("li"));
//		System.out.println(searchitems.size());
		for(WebElement keyword: searchitems) {
			try {
				
				driver.findElement(By.linkText("PIM")).click();
				result=true;
				break;
				
				
				}catch(StaleElementReferenceException e)
			{
				
			}
			
		}
//			JavascriptExecutor js= (JavascriptExecutor)driver;
//			js.executeScript(Window.scr)
			driver.findElement(By.xpath("//*[@class='oxd-icon-button oxd-main-menu-button']")).click();
//			System.out.println("rest");
//			driver.findElement(By.className("oxd-button oxd-button--medium oxd-button--secondary")).click();
			driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
			String username = RandomStringUtils.randomAlphabetic(8);
			driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-firstname']")).sendKeys(username);
			System.out.println(username);
			String lastname=RandomStringUtils.randomAlphabetic(8);
			driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-lastname']")).sendKeys(lastname);
			System.out.println(lastname);
			driver.findElement(By.xpath("//*[@class='oxd-icon-button oxd-main-menu-button']")).click();
			
			String EpmId = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']")).getAttribute("value");
			System.out.println(EpmId);
			WebDriverWait wait= new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='submit']"))).click();
			
//			Thread.sleep(100000);
			
//			driver.findElement(By.xpath("//*[@type='submit']")).click();
			Boolean result1=false;
			List<WebElement> tablinks=driver.findElement(By.xpath("//*[@class='orangehrm-tabs' and @role='tablist']")).findElements(By.tagName("a"));
			
			System.out.println(tablinks.size());
			String Link_to_click="Job";
			
			for(WebElement web:tablinks) 
			{
//				System.out.println(web.getText());
				try {
					if(web.getText().equalsIgnoreCase(Link_to_click)) 
						driver.findElement(By.partialLinkText(Link_to_click)).click();
						result1=true;
					}catch(StaleElementReferenceException e) 
							{
					
							}
			}
			WebDriverWait wait1= new WebDriverWait(driver, 120);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-icon bi-calendar oxd-date-input-icon']"))).click();
//			driver.findElement(By.xpath("//*[@class='oxd-icon bi-calendar oxd-date-input-icon']")).click();
//			driver.findElement(By.className("oxd-icon bi-calendar oxd-date-input-icon")).click();
//			driver.findElement(By.xpath("//*[@class='oxd-date-input']")).click();
			String Date_Of_join="2018-23-04";
			String temp[]=Date_Of_join.split("-");
			System.out.println(temp[0]);
			System.out.println(temp[1]);
			System.out.println(temp[2]);
			driver.findElement(By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-icon-button__icon']")).click();
			
//			driver.findElement(By.className("oxd-icon bi-caret-down-fill oxd-icon-button__icon")).click();
			
			
			
			
			
			
			}
		}
		

		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
    	
//        String baseUrl = "https://epm-test-stgepmcs.epm.us-ashburn-1.ocs.oc-test.com/epmcloud";
//        
//   
////        String expectedTitle = "Welcome: Mercury Tours";
////        String actualTitle = "";
//
//        // launch Fire fox and direct it to the Base URL
//        driver.get(baseUrl);
//        
//        driver.findElement(By.xpath("//input[@class='oj-sm-12 oj-form-control oj-inputtext-nocomp']")).sendKeys("epmuser");
//        driver.findElement(By.xpath("//input[@class='oj-inputpassword-input oj-component-initnode']")).sendKeys("EPM_Welc0me!");
//        driver.findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
//        Thread.sleep(100000);
//        driver.findElement(By.xpath("//a[@class='oj-flex oj-ux-ico-menu oj-ux-icon-size-6x']")).click();
//        
//
//        List<WebElement> links = driver.findElement(By.xpath("//div[@class='oj-form oj-enabled oj-efficient oj-form-cols' ]")).findElements(By.tagName("a"));
//        int linkscount=links.size();
//        System.out.println(linkscount);
//        for (WebElement webElement : links) {
//        	System.out.println(webElement.getText());
//        	String link_to_click="Data Exchange";
//        	if (webElement.getText().equals(link_to_click)) 
//        	{
//				driver.findElement(By.linkText(link_to_click)).click();
////				Thread.sleep(100000);
//				driver.findElement(By.xpath("//*[@title='Actions']")).click();
//				
//			}
//			
//		}
        // get the actual value of the title
//        String actualTitle = driver.getTitle();
//        System.out.println(actualTitle);

	


