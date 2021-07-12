package olxautomation.olxautomation;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	public static WebDriver driver;
	public static Actions act;
	public static WebDriverWait wait;
	public static ChromeOptions Options;

	@BeforeMethod
	    public void main() throws IOException, InterruptedException
    {
		
    	 	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chrome\\chromedriver.exe");
    		driver = new ChromeDriver();
    		driver.get("https://www.olx.in/");
    		driver.manage().window().maximize();
    		Thread.sleep(3000);
     		Options = new ChromeOptions();    
     		Options.addArguments("--disable-notifications");
     		driver.findElement(By.xpath("//span[text()='Login']")).click();
    		Thread.sleep(1000);
    		driver.findElement(By.xpath("//span[text()='Continue with Phone']")).click();
    		Thread.sleep(1000);
    		driver.findElement(By.id("phone")).sendKeys("8148587787");
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//span[text()='Next']")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.id("password")).sendKeys("MultiUse@89");
    		Thread.sleep(1000);
    		driver.findElement(By.xpath("//span[text()='Log in']")).click();
    		Thread.sleep(3000);
    		act = new Actions(driver);
    		act.moveToElement(driver.findElement(By.xpath("//button[@id='wzrk-cancel']"))).click().perform();
    		Thread.sleep(3000);
    		wait = new WebDriverWait(driver, 30);
     		
    }

	@Test(priority = 1)
	public void chat() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@data-aut-id='btnChat']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='unread chats']")));
		driver.findElement(By.xpath("//div[text()='unread chats']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@data-aut-id='conversationUsername']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='continue to chat']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@data-aut-id='inputBox']")).sendKeys("Hi, kindly call 9790734703");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@data-aut-id='btnSend']")).click();
	}

	@Test(priority = 2)
	public void refreshAds() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-aut-id='iconProfile']")));
		driver.findElement(By.xpath("//div[@data-aut-id='iconProfile']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Ads']")));
		driver.findElement(By.xpath("//span[text()='My Ads']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@title='More']")));
		act.moveToElement(driver.findElement(By.xpath("//i[@title='More']"))).click().perform();
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(By.xpath("//li[text()='Edit']"))).click().perform();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Find element by link text and store in variable "Element"
		WebElement Element = driver.findElement(By.id("description"));
		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(By.id("description")).sendKeys("Hi");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Your ad is waiting to go live']")));

	}

	@AfterMethod()

	public void close() {
		driver.close();
	}

}
