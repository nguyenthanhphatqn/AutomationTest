package Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PageObject.RegisterOb;

public class Register extends Astractclass {
	
	public static void main(String[] args) {
		
	}
	@Test(groups = {"001"},priority = 0)
	public void CheckRegister() {
		RegisterOb ro = new RegisterOb(driver);
		
		driver.get(baseURL + "account-login");
		WebElement register = driver.findElement(By.xpath("//div[@class='link register-link']"));
		register.click();
		WebElement popupp = driver.findElement(By.xpath("//div[@class='popup-login-content register-content']"));
		if(popupp.isDisplayed()) {
			ro.enterPhone("1");
			ro.enterPass("");
			ro.enterPassRetype("");
			ro.clickLogin();
//			driver.findElement(By.name("phone")).sendKeys("0");
//			driver.findElement(By.name("password")).sendKeys("12345678");
//			driver.findElement(By.name("password-retype")).sendKeys("12345678");
//			driver.findElement(By.xpath("//div[@class='btn-yellow btn-register']")).click();
		}
		
	}
	@Test(groups = {"002"},priority = 1)
	public void CheckRegisterPassword() {
		RegisterOb ro = new RegisterOb(driver);
		driver.get(baseURL + "account-login");
		WebElement register = driver.findElement(By.xpath("//div[@class='link register-link']"));
		register.click();
		WebElement popupp = driver.findElement(By.xpath("//div[@class='popup-login-content register-content']"));
		if(popupp.isDisplayed()) {
			ro.enterPhone("");
			ro.enterPass("1");
			ro.enterPassRetype("1");
			ro.clickLogin();
//			driver.findElement(By.name("phone")).sendKeys("0345678803");
//			driver.findElement(By.name("password")).sendKeys("12");
//			driver.findElement(By.name("password-retype")).sendKeys("12");
//			driver.findElement(By.xpath("//div[@class='btn-yellow btn-register']")).click();
		}
	}
	@Test(groups = {"003"},priority = 2)
	public void CheckRegisterPasswordType() {
		RegisterOb ro = new RegisterOb(driver);
		driver.get(baseURL + "account-login");
		WebElement register = driver.findElement(By.xpath("//div[@class='link register-link']"));
		register.click();
		WebElement popupp = driver.findElement(By.xpath("//div[@class='popup-login-content register-content']"));
		if(popupp.isDisplayed()) {
			ro.enterPhone("0339662602");
			ro.enterPass("phat12345");
			ro.enterPassRetype("phat12344");
			ro.clickLogin();
		}
	}

	@Test(groups = {"003"},priority = 2)
	public void Register() {
		RegisterOb ro = new RegisterOb(driver);
		driver.get(baseURL + "account-login");
		WebElement register = driver.findElement(By.xpath("//div[@class='link register-link']"));
		register.click();
		WebElement popupp = driver.findElement(By.xpath("//div[@class='popup-login-content register-content']"));
		if(popupp.isDisplayed()) {
			ro.enterPhone("0345678803");
			ro.enterPass("12345678");
			ro.enterPassRetype("12345678");
			ro.clickLogin();
//			driver.findElement(By.name("phone")).sendKeys("0345678804");
//			driver.findElement(By.name("password")).sendKeys("12345678");
//			driver.findElement(By.name("password-retype")).sendKeys("12345678");
//			driver.findElement(By.xpath("//div[@class='btn-yellow btn-register']")).click();
//			driver.findElement(By.name("otp")).sendKeys("314857");
//			driver.findElement(By.xpath("//div[@class='btn-yellow btn-confirm-otp']")).click();
		}
	}
	
}
