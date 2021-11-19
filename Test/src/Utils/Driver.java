package Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Driver {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFCell cell;
	private WebDriver driver;
	private String url = "https://tocotocotea.com/account-login/";

	@BeforeTest
	public void TestSetup() {
		System.setProperty("webdriver.chrome.driver","E:\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get(url);
	}

	@Test
	public void Read() {
		// Import file excel
		File src = new File("E:\\KTTD\\Test\\test\\ExcelUtils.xlsx");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet("Sheet1");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			

			// Import data for Phone.
			cell = sheet.getRow(i).getCell(0);
			//cell.setCellType(Cell.CELL_TYPE_STRING);
			driver.findElement(By.xpath("//input[@name='phone']")).clear();
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(cell.getStringCellValue());

			// Import data for password.
			cell = sheet.getRow(i).getCell(1);
			//cell.setCellType(Cell.CELL_TYPE_STRING);
			driver.findElement(By.xpath("//input[@name='password']")).clear();
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(cell.getStringCellValue());
			// To click on Login button
			driver.findElement(By.xpath("//div[@class='login-btn btn-yellow']")).click();
			// To write data in the excel
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(src);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Message to be written in the excel sheet
			String message = "Pass";
			// Create cell where data needs to be written.
			sheet.getRow(i).createCell(2).setCellValue(message);

			// finally write content
			try {
				workbook.write(fos);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// close the file
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}