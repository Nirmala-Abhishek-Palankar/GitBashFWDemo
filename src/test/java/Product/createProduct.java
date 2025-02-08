package Product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.VtigerHomePage;

public class createProduct {

	public static void main(String[] args) throws Throwable {
		
		File_Utility flib = new File_Utility();
		 WebDriver_Utility wlib = new WebDriver_Utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility();
		 
		 WebDriver driver;
		 String BROWSER = flib.getKeyAndValuePair("browser");
		 if(BROWSER.equalsIgnoreCase("chrome"))
		 {
			  driver=new ChromeDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("fireFox"))
		 {
			 driver=new FirefoxDriver();
		 }
		 else
		 {
			 driver=new ChromeDriver();
		 }
		 String URL = flib.getKeyAndValuePair("url");
		 String USERNAME = flib.getKeyAndValuePair("username");
		 String PASSWORD = flib.getKeyAndValuePair("password");
		
		wlib.maximizeWindow(driver);
		//wlib.elementsToGetLoaded(driver);
      
		driver.get(URL);
		LoginVtigerPage login = new LoginVtigerPage(driver);
		login.loginIntoVtiger(USERNAME, PASSWORD);
     
		int ranNum = jlib.getRandomNum();
   
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickPrdLink();
		
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	
	
	String productData = elib.ReadExcelData("Product", 0, ranNum)+ranNum;
	driver.findElement(By.name("productname")).sendKeys(productData);

   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
   Thread.sleep(2000);
   driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
   driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
