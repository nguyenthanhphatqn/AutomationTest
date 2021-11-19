package Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Franchise extends Astractclass {

	@Test(groups = {"001"},priority = 0)
	public void Franchise() {
		driver.get(baseURL);
		WebElement fran = driver.findElement(By.xpath("//*[@id=\"menu-item-1551\"]"));
		fran.click();
	}
}
