package Campaign;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CampDetailedPage;
import ObjectRepo.CampValidatePage;
import ObjectRepo.CreateCampPage;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.VtigerHomePage;

@Listeners(Generic_Utilities.Listeners.class)
public class CreateCampaignTest extends BaseClass
{
	@Test
	public void createCampaignTest() throws Throwable {

		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		File_Utility flib = new File_Utility();

		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");
		driver.get(URL);

		// using business logics
		LoginVtigerPage login = new LoginVtigerPage(driver);
		login.loginIntoVtiger(USERNAME, PASSWORD);

		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);

		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickMoreLink();
		home.clickCampLink();

		CampDetailedPage img = new CampDetailedPage(driver);
		img.clickCampLookUpImg();

		int ranNum = jlib.getRandomNum();
//----------------------------------------------------------------------------------------------------------		

		String CampName = elib.ReadExcelData("Campaign", 0, 0) + ranNum;

		CreateCampPage createPage = new CreateCampPage(driver);
		createPage.enterCampName(CampName);

		createPage.clickSaveButton();

		CampValidatePage validate = new CampValidatePage(driver);
		validate.validateCampaign(driver, CampName);

		home.logoutApp();
	}public void CreateCampaignWithProductTest()
	{
		
	}
}
