package Shashankagra.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Shashankagra.abstractclass.abstractclasses;

public class Productca extends abstractclasses {
	WebDriver driver;
	
	public Productca(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css="#toast-container")
	WebElement Addtocarttext;
	
	@FindBy(css=".ng-animating")
	WebElement dark;
	
	By products1 = By.cssSelector(".mb-3");
		
	public List<WebElement> getproduct()
	{
		WaitForElementToAppear(products1);
		return products;
	}
	//		WebElement p = Products.stream().filter(Product->Product.findElement(By.cssSelector("b")).getText().equals(product)).findFirst().orElse(null);

	public WebElement choseproduct(String productname)
	{
		WebElement p = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return p;
	}
	public void Addtocart(String productname)
	{
	//	p.findElement(By.xpath("//div/button[2]")).click();
		WebElement p = choseproduct(productname);
		p.findElement(By.xpath("//div/button[2]")).click();
		WaitForElementToAppear1(Addtocarttext);
		WaitForElementToDisappear(dark);
	}
}
