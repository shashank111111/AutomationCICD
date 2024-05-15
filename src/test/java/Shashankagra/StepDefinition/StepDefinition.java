package Shashankagra.StepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

import Shashankagra.Testcomponents.Base1;
import Shashankagra.pages.Landingpage;
import Shashankagra.pages.Productca;
import Shashankagra.pages.cartpage;
import Shashankagra.pages.checkoutpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends Base1 {

	public Landingpage landingpage;
	public Productca productca;
	@Given("Landed on ecommerce site")
	public void landed_on_ecommerce_site() throws IOException {
		landingpage = launchweb();
		}
	@Given("Logged in with username {string} and password {string}")
	public void logged_in_with_username_and_password(String username, String password) {
		Productca productca=landingpage.login(username, password);
		}
	@When("I add product {string} to cart")
	public void i_add_product_to_cart(String productname) {
	List<WebElement> productlist= productca.getproduct();
		productca.Addtocart(productname);
	       }
	@Then("checkout {string} and submit the order")
	public void checkout_and_submit_the_order(String productname) {
	 	cartpage cart = productca.gotocartpage();
			checkoutpage checkout =cart.checkproduct(productname);
			checkout.selectcountry("india");	
	    }
	@AfterTest()
	public void close()
	{
		driver.close();
	}
	

}
