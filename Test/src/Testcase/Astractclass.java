package Testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Astractclass {
	public static String baseURL = "https://tocotocotea.com/";
	public static String driverpath = "E:\\chrome\\chromedriver.exe";
	public static WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		System.out.println("Open Chrome browser");
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get(baseURL);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
//	@AfterTest
//	public void close()
//	{
//	    driver.close();
//	}
	}
