package Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Recruitment extends Astractclass{

	@Test(groups = {"001"},priority = 0)
	public void Recruit() {
		driver.get(baseURL);
		WebElement recruit = driver.findElement(By.xpath("//*[@id=\"menu-item-12301\"]"));
		recruit.click();
		
		String expectedURL = "https://tocotocotea.com/tuyen-dung/";
		driver.get(expectedURL);
		String actualURL = driver.getCurrentUrl();
		if(actualURL.equalsIgnoreCase(expectedURL))
			System.out.println("The expected and actual URLs are same !!!");
		else
			System.out.println("The URLs are different  !!!");
	}
}
