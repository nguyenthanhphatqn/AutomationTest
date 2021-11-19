package Testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Introduce extends Astractclass {

	@Test(groups = {"001"},priority = 0)
	public void Introduce() {
		driver.get(baseURL);
		Actions action = new Actions(driver);
		WebElement dropdownlist = driver.findElement(By.xpath("//*[@id=\"menu-item-1272\"]"));
		action.moveToElement(dropdownlist).perform();
		String need_find = "Lịch sử và sứ mệnh";
		List<WebElement> dropdown_items = dropdownlist.findElements(By.tagName("li"));
		for(int i = 0; i<dropdown_items.size(); i++) {
			if(dropdown_items.get(i).getText().equals(need_find)) {
				dropdown_items.get(i).findElement(By.tagName("a")).click();
			}
		}
		String expectedURL = "https://tocotocotea.com/history/";
		driver.get(expectedURL);
		String actualURL = driver.getCurrentUrl();
		if(actualURL.equalsIgnoreCase(expectedURL))
			System.out.println("The expected and actual URLs are same !!!");
		else
			System.out.println("The URLs are different !!!");
	}
}
