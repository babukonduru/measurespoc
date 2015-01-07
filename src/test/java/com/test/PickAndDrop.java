package com.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;  
import org.openqa.selenium.firefox.FirefoxDriver;  
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;  
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class PickAndDrop {  

	private WebDriver driver;

	@BeforeClass
	public void testPickAndDrop(){

		//Open Firefox Browser
		FirefoxProfile profile = new FirefoxProfile();  
		profile.setEnableNativeEvents(true);  
		driver = new FirefoxDriver(profile); 
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void EnterUrl(){
		//Enter Site URL
		driver.get("http://localhost:8083/Measures-POC/poc");  
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		//driver.switchTo().frame(0);    
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	//Test case 2(Enter Formula Name)
	@Test(priority=2)
	public void EnterFormulaName(){
		driver.findElement(By.id("displayFormula")).sendKeys("FormulaCreationTest");
	}



	//Test case 3(Perform Drag and Drop Operation in Numerator)
	@Test(priority=3)
	public void AddToNumerator(){

		//Perform Drag and Operation in numerator
		WebElement dragElement = driver.findElement(By.xpath(".//label[@id='poc' and contains(text(), 'Maths')]"));
		WebElement dropElement=driver.findElement(By.id("nmvalue"));  
		Actions builder = new Actions(driver);		
		builder.dragAndDrop(dragElement, dropElement).build().perform();

		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);		

		WebElement dragElementAdd1 = driver.findElement(By.xpath(".//label[@id='poc' and contains(text(), '+')]"));
		WebElement dropElementAdd1=driver.findElement(By.id("nmvalue")); 
		Actions builderAdd1 = new Actions(driver);		
		builderAdd1.dragAndDrop(dragElementAdd1, dropElementAdd1).build().perform();

		WebElement dragElement2 = driver.findElement(By.xpath(".//label[@id='poc' and contains(text(), 'Physics')]"));
		WebElement dropElement2=driver.findElement(By.id("nmvalue")); 
		Actions builder2 = new Actions(driver);		
		builder2.dragAndDrop(dragElement2, dropElement2).build().perform();

	}


	//Test case 4(Perform Drag and Drop operation in Denumerator)
	@Test(priority=4)
	public void AddToDenumerator(){
		//Add Subjects in DeNominator
		WebElement dragElement3 = driver.findElement(By.xpath(".//label[@id='poc' and contains(text(), 'German')]"));
		WebElement dropElement3=driver.findElement(By.id("dmvalue"));  
		Actions builder3 = new Actions(driver);		
		builder3.dragAndDrop(dragElement3, dropElement3).build().perform();

		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);		

		WebElement dragElementNum1 = driver.findElement(By.xpath("//tr[2]/td[2]/label/label[2]"));
		WebElement dropElementNum1=driver.findElement(By.id("dmvalue")); 
		Actions builderNum1 = new Actions(driver);		
		builderNum1.dragAndDrop(dragElementNum1, dropElementNum1).build().perform();


		//Perform Drag and Drop Operation in DeNominator
		WebElement dragElement4 = driver.findElement(By.xpath(".//label[@id='poc' and contains(text(), 'French')]"));
		WebElement dropElement4=driver.findElement(By.id("dmvalue")); 
		Actions builder4 = new Actions(driver);		
		builder4.dragAndDrop(dragElement4, dropElement4).build().perform();
	}


	//Test case 5(Submit and save the changes)
	@Test(priority=5)
	public void SubmitTheChanges(){
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@AfterClass
	public void tearDown(){
		//if(driver != null)
		//	driver.quit(); 
	}


}



