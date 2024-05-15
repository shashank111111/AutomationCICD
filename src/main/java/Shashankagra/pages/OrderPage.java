package Shashankagra.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Shashankagra.abstractclass.abstractclasses;

public class OrderPage extends abstractclasses {
	WebDriver driver;
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productnames;
	
	public void Varify(String product)
	{
		Boolean match = productnames.stream().anyMatch(productname->productname.getText().equalsIgnoreCase(product));
		assertTrue(match);
		System.out.print(match);
	//	driver.findElement(By.cssSelector("li[class='totalRow'] button[type='button']")).click();
	//	checkoutpage checkout = new checkoutpage(driver);
	//	return checkout;
	}
	

}
