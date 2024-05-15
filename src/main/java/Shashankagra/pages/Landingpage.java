package Shashankagra.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Shashankagra.abstractclass.abstractclasses;

public class Landingpage extends abstractclasses {
	
	WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormesage;
	
	public Productca login(String user,String Pass)
	{
		driver.findElement(By.id("userEmail")).sendKeys(user);
		driver.findElement(By.id("userPassword")).sendKeys(Pass);
		driver.findElement(By.id("login")).click();
		Productca productca = new Productca(driver);
		return productca;
		

	}
	
	public void gotopage()
	{
	//	driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	//name attribute is not available for this element
	//div[class='ng-tns-c4-6 toast-message ng-star-inserted']
	
	public String geterrormessage()
	{
		WaitForElementToAppear2(errormesage);
		return errormesage.getText();
	}
	
	
	

}
