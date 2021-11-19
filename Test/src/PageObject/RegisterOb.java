package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class RegisterOb {
	private WebDriver driver;
	private By phonerg = By.xpath("//input[@name='phone']");
	private By passwordrg = By.xpath("//input[@name='password']");
	private By passwordretyperg = By.xpath("//input[@name='password-retype']");
	private By buttonrg = By.xpath("//div[@class='btn-yellow btn-register']");
	public RegisterOb(WebDriver driver) {
		this.driver = driver;
	}
	public String getRegisterPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	public boolean verifyRegisterPageTitle() {
		String expectedTitle = "Sign In";
		return getRegisterPageTitle().equals(expectedTitle);
	}
//	public boolean verifyRegisterPageText() {
//		WebElement element = driver.findElement(headerPageText);
//		String pageText = element.getText();
//		String expectedPageText = "Forgot Username/Password?";
//		return pageText.contains(expectedPageText);
//	}
	
	public void enterPhone(String phone) {
		WebElement phoneregister = driver.findElement(phonerg);
		if(phoneregister.isDisplayed()) 
			phoneregister.sendKeys(phone);
	}
	public void enterPass(String password) {
		WebElement passwordregister = driver.findElement(passwordrg);
		if(passwordregister.isDisplayed()) 
			passwordregister.sendKeys(password);
	}
	public void enterPassRetype(String passwordre) {
		WebElement passwordrt = driver.findElement(passwordretyperg);
		if(passwordrt.isDisplayed()) 
			passwordrt.sendKeys(passwordre);
	}
	public void clickLogin() {
		WebElement register = driver.findElement(buttonrg);
		if(register.isDisplayed()) {
			register.click();
		}	
	}

}
