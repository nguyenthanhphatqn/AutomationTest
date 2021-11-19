package Testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginOb;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login extends Astractclass {
	public boolean checkIfTestCaseIsPassed;
	public boolean checkIfTestCaseIsFailed;
	public final String invalidPhone = "Số điện thoại không hợp lệ";
	public final String invalidPassword = "Mật khẩu phải từ 8 - 16 ký tự";
	public By phoneLocator = By.xpath("//div//input//preceding-sibling::div[1]");
	public By passwordLocator = By.xpath("//div//input[@type=\"password\" and @name]//following-sibling::div[1]");

	@Test(groups = {"001"},priority = 0)
	public void CheckLoginPhoneFail() {
		LoginOb lo = new LoginOb(driver);
		driver.get(baseURL + "order/?source_id=web");
		WebElement login = driver.findElement(By.xpath("//div[@class='login-button']"));
		login.click();
		WebElement popupp = driver.findElement(By.xpath("//div[@class='popup-login-content login-content']"));
		if(popupp.isDisplayed()) {
			lo.enterPhone("1");
			lo.enterPass("");
			lo.clickLogin();
//			driver.findElement(By.name("phone")).sendKeys("1");
//			driver.findElement(By.name("password")).sendKeys("");
//			driver.findElement(By.xpath("//div[@class='login-btn btn-yellow']")).click();
		}
		if (driver.findElement(phoneLocator).getText().equals(invalidPhone)==true
			    || driver.findElement(phoneLocator).getText().contains(invalidPhone)==true) {

			    this.checkIfTestCaseIsPassed=true;
			    if (this.checkIfTestCaseIsPassed) {
			        Assert.assertFalse(false);
			    }
			}
			else {
			        this.checkIfTestCaseIsFailed= true;
			        Assert.assertFalse(true);
			}
	}
	@Test(groups = {"002"}, priority = 1)
	public void CheckLoginPassword() {
		LoginOb lo = new LoginOb(driver);
		driver.get(baseURL + "order/?source_id=web");
		WebElement login = driver.findElement(By.xpath("//div[@class='login-button']"));
		login.click();
		WebElement popupp = driver.findElement(By.xpath("//div[@class='popup-login-content login-content']"));
		if(popupp.isDisplayed()) {
			lo.enterPhone("");
			lo.enterPass("1");
			lo.clickLogin();
//			driver.findElement(By.name("phone")).sendKeys("");
//			driver.findElement(By.name("password")).sendKeys("1");
//			driver.findElement(By.xpath("//div[@class='login-btn btn-yellow']")).click();
		}
		if (driver.findElement(passwordLocator).getText().equals(invalidPassword)==true
			    || driver.findElement(passwordLocator).getText().contains(invalidPassword)==true) {

			    this.checkIfTestCaseIsPassed=true;
			    if (this.checkIfTestCaseIsPassed) {
			        Assert.assertFalse(false);
			    }
			}
			else {
			        this.checkIfTestCaseIsFailed= true;
			        Assert.assertFalse(true);
			}
		
	}
	@Test(groups = {"003"},priority = 2)
	public void Login() {
		LoginOb lo = new LoginOb(driver);
		driver.get(baseURL + "/account-login/");
//		WebElement login = driver.findElement(By.xpath("//div[@class='login-button']"));
//		login.click();
		WebElement popupp = driver.findElement(By.xpath("//div[@class='popup-login-content login-content']"));
		if(popupp.isDisplayed()) {
			lo.enterPhone("0326977968");
			lo.enterPass("phat230900");
			lo.clickLogin();
//			driver.findElement(By.name("phone")).sendKeys("0326977968");
//			driver.findElement(By.name("password")).sendKeys("phat230900");
//			driver.findElement(By.xpath("//div[@class='login-btn btn-yellow']")).click();
		}
		if(driver.findElement(By.xpath("//div[@class=\"user-fullname\"]")).getText().equals("Nguyễn Ngọc Thành")) {
			Assert.assertFalse(false);
			System.out.println("The expected and actual URLs are same !!!");
		}
		else {
			Assert.assertFalse(true);
		}
	}
}
