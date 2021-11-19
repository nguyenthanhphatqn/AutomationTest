package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginOb {
	private WebDriver driver;
	private By phonelg = By.xpath("//input[@name='phone']");
	private By passwordlg = By.xpath("//input[@name='password']");
	private By buttonlg = By.xpath("//div[@class='login-btn btn-yellow']");
	public LoginOb(WebDriver driver) {
		this.driver = driver;
	}
	public void enterPhone(String phone) {
		WebElement phonelogin = driver.findElement(phonelg);
		if(phonelogin.isDisplayed()) 
			phonelogin.sendKeys(phone);
	}
	public void enterPass(String password) {
		WebElement passwordlogin = driver.findElement(passwordlg);
		if(passwordlogin.isDisplayed()) 
			passwordlogin.sendKeys(password);
	}
	public void clickLogin() {
		WebElement login = driver.findElement(buttonlg);
		if(login.isDisplayed()) {
			login.click();
		}	
	}
}
