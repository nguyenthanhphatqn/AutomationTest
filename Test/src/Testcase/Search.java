package Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.SearchOb;

public class Search extends Astractclass{
	public final String product = "Sữa Chua Trắng";
	
	@Test(groups = {"001"},priority = 0)
	public void Search() {
		driver.get(baseURL + "order/?source_id=web");
		WebElement searchproduct = driver.findElement(By.xpath("/html/body/div[1]/div[2]/input"));
		SearchOb so = new SearchOb(driver);
		so.enterSearch(product);
//		searchproduct.sendKeys("Sữa Chua Trắng");
//		searchproduct.sendKeys(Keys.RETURN);
		if(driver.findElement(By.xpath("//div[@class=\"product-name\"]")).getText().equalsIgnoreCase(product)) {
			 Assert.assertFalse(false);
		}
		else
			 Assert.assertFalse(true);
	}
}
