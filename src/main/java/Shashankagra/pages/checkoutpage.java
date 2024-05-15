package Shashankagra.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Shashankagra.abstractclass.abstractclasses;

public class checkoutpage extends abstractclasses{
	WebDriver driver;
	
	public checkoutpage(WebDriver driver)
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	By countryoption = By.cssSelector("span.ng-star-inserted");
	@FindBy(css="span.ng-star-inserted")
	List<WebElement> options;
	
//	driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("Ind");
	//	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.ng-star-inserted")));
//		List<WebElement> options = driver.findElements(By.cssSelector("span.ng-star-inserted"));
	
	public void selectcountry(String country)	
	{
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("Ind");
		WaitForElementToAppear(countryoption);
		for(WebElement option: options)
		{
			
			if(option.getText().equalsIgnoreCase(country))
			{
			option.click();
			break;
		}}
		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();

	}
	
	
}
