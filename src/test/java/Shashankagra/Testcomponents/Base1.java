package Shashankagra.Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Shashankagra.pages.Landingpage;

public class Base1 {
public	WebDriver driver;
public Shashankagra.pages.Landingpage landingpage;
	
	public WebDriver initilize() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\selenium12\\src\\main\\java\\Shashankagra\\resources\\GlobalData.properties");
		prop.load(fis);
		String Browsername = prop.getProperty("browser");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	public List<HashMap<String, String>> getjsonDataToMap(String filepath) throws IOException
	{
		// read json to string
		String JsonContent= 	FileUtils.readFileToString(new File(filepath),
				StandardCharsets.UTF_8);
	// String to Hashmap
		
		ObjectMapper newobj = new ObjectMapper();
		List<HashMap<String,String>> data = newobj.readValue(JsonContent, new TypeReference <List<HashMap<String,String>>>(){});
		
		return data;
		
	
	}
	@BeforeMethod(alwaysRun=true)
	public Landingpage launchweb() throws IOException
	{
		driver = initilize();
		landingpage = new Shashankagra.pages.Landingpage(driver);
		landingpage.gotopage();
		return landingpage;
	}
}
