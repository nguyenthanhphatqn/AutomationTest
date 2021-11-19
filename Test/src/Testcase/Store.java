package Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Store extends Astractclass {

	public static void main(String[] args) {
		
	}
	@Test(groups = {"001"},priority = 0)
	public void Store() {
		driver.get(baseURL);
		WebElement store = driver.findElement(By.xpath("//*[@id=\"menu-item-1281\"]"));
		store.click();
		
		String expectedURL = "https://tocotocotea.com/stores/";
		driver.get(expectedURL);
		String actualURL = driver.getCurrentUrl();
		if(actualURL.equalsIgnoreCase(expectedURL))
			System.out.println("The expected and actual URLs are same !!!");
		else
			System.out.println("The URLs are different  !!!");
	}

}
