package Shashankagra.Tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Shashankagra.Testcomponents.Base1;
import Shashankagra.pages.OrderPage;
import Shashankagra.pages.Productca;
import Shashankagra.pages.cartpage;
import Shashankagra.pages.checkoutpage;


public class Final111 extends Base1{
//	String product;
	//	String product = "ZARA COAT 3";


	@Test(dataProvider = "getdata" ,groups = {"purchase"})
	public void Final(HashMap<String,String> input) throws IOException, InterruptedException

	{
	//	String product = "ZARA COAT 3";
		String country ="India";
	//	Shashankagra.pages.Landingpage landingpage = launchweb();
		Productca productca=landingpage.login(input.get("user"), input.get("pass"));
		List<WebElement> productlist= productca.getproduct();
		WebElement p =productca.choseproduct(input.get("pro"));
		productca.Addtocart(input.get("pro"));
		cartpage cart = productca.gotocartpage();
		checkoutpage checkout =cart.checkproduct(input.get("pro"));
		checkout.selectcountry(country);	
	}
	
/*	@Test(dependsOnMethods= {"Final"})
	public void orderhistorycheck()
	{
		Productca productca=landingpage.login("s19@gmail.com", "258369Qp@");
		OrderPage Orderpage = productca.gotoOrgerpage();
		Orderpage.Varify(product);
	}     */
//	@DataProvider
//	public Object[][] getdata()
//	{
//		return new Object[][] { {"s19@gmail.com","258369Qp@","ZARA COAT 3"},{"s19@gmail.com","258369Qp@","ZARA COAT 3"}};
//	}
	
	@DataProvider
	public Object[][] getdata()
	{
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("user","s19@gmail.com" );
		map.put("pass", "258369Qp@");
		map.put("pro", "ZARA COAT 3");
	
//	getjsonDataToMap();
//	List<HashMap<String,String>> data=	getjsonDataToMap("C:\\Users\\Asus\\eclipse-workspace\\selenium12\\src\\test\\java\\Shashankagra\\data\\purchase.json");
//
	return new Object[][] {{map}};
	}

}
