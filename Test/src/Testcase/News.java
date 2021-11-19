package Testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class News extends Astractclass {

	@Test(groups = {"001"},priority = 0)
	public void News() {
		driver.get(baseURL);
		Actions action = new Actions(driver);
		WebElement dropdownlist = driver.findElement(By.xpath("//*[@id=\"menu-item-2057\"]"));
		action.moveToElement(dropdownlist).perform();
		String need_find = "SỰ KIỆN";
		List<WebElement> dropdown_items = dropdownlist.findElements(By.tagName("li"));
		for(int i = 0; i<dropdown_items.size(); i++) {
			if(dropdown_items.get(i).getText().equals(need_find)) {
				dropdown_items.get(i).findElement(By.tagName("a")).click();
				System.out.println("Đã nhấn vào mục sự kiện");
			}
		}
	}
}
