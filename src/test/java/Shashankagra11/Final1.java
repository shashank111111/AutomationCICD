package Shashankagra11;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Final1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String product = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.findElement(By.id("userEmail")).sendKeys("s19@gmail.com");
//		driver.findElement(By.id("userPassword")).sendKeys("258369Qp@");
//		driver.findElement(By.id("login")).click();
//		Shashankagra.pages.Landingpage landingpage = new Shashankagra.pages.Landingpage(driver);
//		landingpage.login(product, product)
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
		List<WebElement> Products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement p = Products.stream().filter(Product->Product.findElement(By.cssSelector("b")).getText().equals(product)).findFirst().orElse(null);
		p.findElement(By.xpath("//div/button[2]")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		List<WebElement> carts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = carts.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(product));
		assertTrue(match);
		driver.findElement(By.cssSelector("li[class='totalRow'] button[type='button']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("Ind");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.ng-star-inserted")));
		List<WebElement> options = driver.findElements(By.cssSelector("span.ng-star-inserted"));
		for(WebElement option: options)
		{
			
			if(option.getText().equalsIgnoreCase("India"))
			{
			option.click();
			break;
		}}
		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		
		
		
	}

}
