package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;

public class CreateProductAndDeleteProduct {

	public static void main(String[] args) throws Throwable {
		
		File_Utility flib = new File_Utility();
		 WebDriver_utility wlib = new WebDriver_utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility();
		 
		 WebDriver driver;
		 String BROWSER = flib.getKeyAndValueData("browser");
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
	     String URL = flib.getKeyAndValueData("url");
		 String USERNAME = flib.getKeyAndValueData("username");
		 String PASSWORD = flib.getKeyAndValueData("password");
		
		 wlib.maximizeWindow(driver);
		 wlib.elementsToGetLoaded(driver);
		 driver.get(URL);
		
		 VtigerLoginPage login = new VtigerLoginPage(driver);
		 login.loginToApp(USERNAME, PASSWORD);
	    
		HomePage home = new HomePage(driver);
		home.clickProductLink();
		
	//	driver.findElement(By.linkText("Products")).click();
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	   CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickOnPlusSign();
		
		int ranNumber = jlib.getRandomNumber();
	
	  String productData = elib.readExcelDataUsingDataFormatter("Product", 1, 1)+ranNumber;
//	 driver.findElement(By.name("productname")).sendKeys(productData);
	prdPage.enterProductName(productData);
	
//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();    
	prdPage.clickSaveButton();
	
//	driver.findElement(By.linkText("Products")).click(); 
	home.clickProductLink();
//	 driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='Product Name']/../preceding-sibling::td//input[@type='checkbox']")).click();
	    
	DeletePrdValidationPage prdValidate = new DeletePrdValidationPage(driver);
	// driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+productData+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
	 prdValidate.deleteProduct(driver, productData);
	 
	// driver.findElement(By.xpath("//input[@value='Delete']")).click();
	 prdValidate.clickOnDeleteButton(wlib, driver);
	
	//	  List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]")); 
//	    	
//	boolean flag = false;
//	
//	for (WebElement prdName : productList)
//	{
//		String actData = prdName.getText();
//		if(actData.contains(productData))
//		{
//			flag=true;
//		   break;
//		}}
//	if(flag)
//	{
//		System.out.println("product data is deleted");
//	}
//	else
//	{
//		System.out.println("product data is not deleted");
//	}
	// System.out.println("pdata"+productData);
	 prdValidate.validateProductDeleted(driver, productData);
//	wlib.alertAccept(driver);
//      driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//      driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
      home.logOutFromApp();
	}

}
