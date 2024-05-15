package Shashankagra.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Shashankagra.abstractclass.abstractclasses;

public class cartpage extends abstractclasses {
	WebDriver driver;
	public cartpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> productlists;
	
	public checkoutpage checkproduct(String product)
	{
		Boolean match = productlists.stream().anyMatch(productlist->productlist.getText().equalsIgnoreCase(product));
		assertTrue(match);
		driver.findElement(By.cssSelector("li[class='totalRow'] button[type='button']")).click();
		checkoutpage checkout = new checkoutpage(driver);
		return checkout;




	}
	

}
