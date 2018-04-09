package com.Naukri_Business_Logic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Naukri_Attachment_Code_Base {
	
WebDriver driver;
	
	@BeforeClass
	public void preSetup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Software\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	@Test
	public void naukri_Login() throws InterruptedException
	{
		//GET URL
		//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/nlogin/login?msg=0&URL=http%3A%2F%2Fmy.naukri.com");
		
		Thread.sleep(5000);
		
		
		//ENTER USERNAME
		try {
			WebElement userElement = driver.findElement(By.xpath("//span[contains(@class,'lbl')]/following-sibling::input[@id='usernameField']"));
			userElement.clear();
			userElement.sendKeys("mishrabhabani@outlook.com");
		} catch (Exception e1) {
			
			driver.findElement(By.xpath("//input[@id='emailTxt' and @name='USERNAME']")).sendKeys("mishrabhabani@outlook.com");
			//e1.printStackTrace();
		}
		
		// ENTER PASSWORD
		try {
			driver.findElement(By.id("passwordField")).sendKeys("godisgreate");
		} catch (Exception e1) {
			
			driver.findElement(By.xpath("//input[@id='pwd1' and @name='PASSWORD']")).sendKeys("godisgreate");
			//e1.printStackTrace();
		}
		Thread.sleep(4000);
		
		//HIT THE LOGIN BUTTON
		try {
			driver.findElement(By.xpath("//button[text()='Login']")).click();
		} catch (Exception e1) {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='sbtLog' and @name='Login']")).click();
			//System.out.println(e1);
		}
		Thread.sleep(4000);
		
		//CLICK ON UPDATE PROFILE BUTTON
		driver.findElement(By.linkText("UPDATE PROFILE")).click();
		
		//Click on Attach Resume Link
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[@class='collection']/li[12]/span[text()='Attach Resume']")).click();
		
		
		//CLICK ON DELATE BUTTON
		Thread.sleep(4000);
		try {
			driver.findElement(By.xpath("//a[text()='DELETE RESUME']")).click();
			
			
			
			//HANDLE DELETE BUTTON APPEAR
			Thread.sleep(4000);

			Actions act = new Actions(driver);
			
			act.click(driver.findElement(By.xpath("html/body/div[5]/div[9]/div/div/button"))).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Delete button not found");
		}
		
		Thread.sleep(4000);
		//driver.findElement(By.id("attachCV")).click();
		WebElement element2= driver.findElement(By.id("attachCV"));
		element2.click();
		Thread.sleep(3000);
		try {
			element2.sendKeys("C:\\Users\\BHABANI\\Desktop\\My Doc\\Bhabani Shankar Mishra.doc");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found to Attachment");
		}
		
		
		Thread.sleep(4000);
		WebElement element3 = driver.findElement(By.xpath("//span[@class='updateOn']"));
		System.out.println("Resume Updated On The Date : ---->>> " + element3.getText());
		//driver.findElement(By.xpath("//a[text()='here']")).click();
		
	}
	
	
	@AfterClass
	public void postSetup() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.quit();
	}
	
	


}
