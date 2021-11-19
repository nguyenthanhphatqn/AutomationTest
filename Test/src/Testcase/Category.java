package Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Category extends Astractclass {
//	public final String cate = "Danh mục";
	@Test(groups = {"001"},priority = 0)
	public void Category() {
		driver.get(baseURL);
		WebElement category = driver.findElement(By.xpath("//li[@id=\"menu-item-1268\"]"));
		category.click();
//		if(driver.findElement(By.xpath("//li[@id=\\\"menu-item-1268\\")).getText().equalsIgnoreCase(cate)) {
//			 Assert.assertFalse(false);
//		}
//		else
//			 Assert.assertFalse(true);
	}

}
