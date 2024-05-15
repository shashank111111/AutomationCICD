package Shashankagra.abstractclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Shashankagra.pages.OrderPage;
import Shashankagra.pages.cartpage;

public class abstractclasses {
	
	WebDriver driver;
	
	public abstractclasses(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void WaitForElementToAppear(By FindBy)
	{
		   WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
		   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FindBy));
	}
	public void WaitForElementToAppear1(WebElement ele)
	{
		   WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
		   wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
	public void WaitForElementToAppear2(WebElement ele)
	{
		   WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(20));
		   wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void WaitForElementToDisappear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfAllElements(ele));
	}
	public cartpage gotocartpage()
	{
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		cartpage cart= new cartpage(driver);
		return cart;
	}
	public OrderPage gotoOrgerpage()
	{
		driver.findElement(By.cssSelector("[routerlink*='myorders']")).click();
		OrderPage Orderpage= new OrderPage(driver);
		return Orderpage;
	}
}
