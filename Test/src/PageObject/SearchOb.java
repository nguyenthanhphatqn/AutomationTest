package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchOb {
	private WebDriver driver;
	private By search = By.xpath("//input[@class=\"input-search\"]");
	public SearchOb(WebDriver driver) {
		this.driver = driver;
	}
	public void enterSearch(String keysearch) {
		WebElement searchpr = driver.findElement(search);	
		if(searchpr.isDisplayed()) 
			searchpr.sendKeys(keysearch);
			searchpr.sendKeys(Keys.RETURN);
	}
	
}
