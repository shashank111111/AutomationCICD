package Shashankagra.Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import Shashankagra.Testcomponents.Base1;
import Shashankagra.pages.Productca;

public class Errorvalidation extends Base1{

	@Test(groups = {"ErrorHandeling"})
	public void Final1() throws IOException, InterruptedException

	{
		Productca productca=landingpage.login("s19@gmail.com", "25836gdsgdg9Qp@");
		assertEquals("Incorrect email or password.", landingpage.geterrormessage());
	//	System.out.println(landingpage.geterrormessage());
	}

}
