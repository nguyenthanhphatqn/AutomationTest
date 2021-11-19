package Testcase;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Productss extends Astractclass {

	@Test(groups = {"001"},priority = 0)
	public void Productss() throws InterruptedException {					
		Random rd = new Random();
		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.get(baseURL + "order/?source_id=web");
		
		///
		WebElement list_product = driver.findElement(By.xpath("//div[@class=\"category\" and @catslug=\"fresh-fruit-tea\"]"));
		List<WebElement> products = list_product.findElements(By.className("product"));
		
		////////////////
		for (int i = 0; i < products.size(); i++) {
			String product_name = products.get(i).findElement(By.className("product-name")).getText();
			if(product_name.equals("Trà dâu tằm pha lê tuyết")) {
				products.get(i).click();
				
				////POPUP
				WebElement popup = driver.findElement(By.className("popup-add-product"));
				if(popup.isDisplayed()) {
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//label[2]")));
					/////CHỌN SIZE
					WebElement size_container = popup.findElement(By.className("size"));
					List<WebElement> size_options = size_container.findElements(By.tagName("input"));
					size_container.findElement(By.xpath("//div//label[2]")).click();
					
					/////CHỌN % ĐƯỜNG
					WebElement sugar_container = popup.findElement(By.className("sugar"));
					List<WebElement> sugar_options = sugar_container.findElements(By.className("container-radio"));
					int random_sugar = rd.nextInt(sugar_options.size());
					sugar_options.get(random_sugar).click();
					System.out.println("Đã chọn % đường: "+sugar_options.get(random_sugar).getText());
					
					
					/////CHỌN % ĐÁ
					WebElement ice_container = popup.findElement(By.className("ice"));
					List<WebElement> ice_options = ice_container.findElements(By.className("container-radio"));
					int random_ice = rd.nextInt(ice_options.size());
					ice_options.get(random_ice).click();
					
					
					/////CHỌN MỘT or NHIỀU TOPPING
					WebElement topping_container = popup.findElement(By.className("topping"));
					List<WebElement> topping_options = topping_container.findElements(By.className("container-checkbox"));
					int rd_qty = rd.nextInt(4) + 1;
					System.out.println("Số lượng topping random: "+rd_qty);
					for(int j = 0; j < rd_qty; j++) {
						int random_pair = rd.nextInt(topping_options.size());
						
						if(!topping_options.get(random_pair).findElement(By.tagName("input")).isSelected()) {
							topping_options.get(random_pair).click();
							System.out.println("Đã chọn vào checkbox: "+topping_options.get(random_pair).getText());
						}
						else if(topping_options.get(random_pair).findElement(By.tagName("input")).isSelected()) {
							System.out.println("Đã chọn trước đó.");
						}
					}
				
				}
			}
		}
		Thread.sleep(10000);
	}
	@Test(groups = {"002"},priority = 1)
	public void Outproduct() throws InterruptedException {	
		WebElement Out = driver.findElement(By.xpath("//div[@class='btn-price-product']"));
		Out.click();
		Thread.sleep(5000);
	}
	@Test(groups = {"003"},priority = 2)
	public void Increase() throws InterruptedException {	
		WebElement ic = driver.findElement(By.xpath("//div[@class='change-quantity increase']"));
		ic.click();
		System.out.println("Đã tăng số lượng thành công");
		Thread.sleep(5000);
	}
	@Test(groups = {"004"},priority = 3)
	public void Decrease() throws InterruptedException {	
		WebElement dc = driver.findElement(By.xpath("//div[@class='change-quantity decrease']"));
		dc.click();
		System.out.println("Đã giảm số lượng thành công");
		Thread.sleep(5000);
	}
//	@Test(groups = {"005"},priority = 4)
//	public void ClearProduct() throws InterruptedException {	
//		WebElement clear = driver.findElement(By.id("clear-cart"));
//		clear.click();
//		System.out.println("Đã xóa thành công");
//		Thread.sleep(5000);
//	}
	@Test(groups = {"006"},priority = 5)
	public void ClickCheckOut() throws InterruptedException {	
		WebElement cco = driver.findElement(By.xpath("//div[@class='button-cart']"));
		cco.click();
		System.out.println("Đã nhấn thanh toán thành công");
		Thread.sleep(1000);
	}
	@Test(groups = {"007"},priority = 6)
	public void Checkout() throws InterruptedException {	
		driver.findElement(By.id("customer-name")).sendKeys("Nguyễn Văn A");
		driver.findElement(By.id("customer-phone")).sendKeys("0347532267");
		driver.findElement(By.id("customer-location")).sendKeys("1 Cách Mạng Tháng 8, Phường 5, Tân Bình, Hồ Chí Minh");
		driver.findElement(By.id("customer-note")).sendKeys("Đầu đường cách mạng tháng 8");
		WebElement search_address = driver.findElement(By.xpath("//div[@class='search-item']"));
		search_address.click();
		WebElement store = driver.findElement(By.xpath("//div[@class='store-name']"));
		store.click();
		WebElement popupp = driver.findElement(By.xpath("//div[@class='popup-choose-store']"));
		if(popupp.isDisplayed()) {
			WebElement stores = driver.findElement(By.xpath("//div[@class='store-item']"));
			stores.click();
		}
		WebElement order = driver.findElement(By.xpath("//div[@class='btn-order']"));
		order.click();
		System.out.println("Đã đặt hàng thành công");
		Thread.sleep(1000);
	}
}
