package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DiscountCoupon {

	WebDriver driver;
	
	@Test
	public void User_Login() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//1. Go to https://live.demoguru99.com/
		driver.get("https://live.demoguru99.com/"); 
		
		//2. Click Mobile
		driver.findElement(By.xpath("//*[@id='nav']/ol/li[1]/a")).click();
		
		//3. Go to Mobile and add iPhone to add cart  
		driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/button")).click(); 
		
		//4. Add Coupon
		driver.findElement(By.xpath("//*[@id='coupon_code']")).sendKeys("GURU50");   
		
		//5. Select United States
		WebElement dropdown = driver.findElement(By.xpath("//*[@id='country']"));      
		
		Select select = new Select(dropdown); 
		
		select.selectByVisibleText("United States");  
		
		//6. Select New York
        WebElement dropdown1 = driver.findElement(By.xpath("//*[@id='region_id']"));       
		
		Select select1 = new Select(dropdown1); 
		
		select1.selectByVisibleText("New York"); 
		
		//7. Enter ZIP Code
		driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("542896");
		
		//8. Proceed to checkout
		driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button")).click();
	}
}
