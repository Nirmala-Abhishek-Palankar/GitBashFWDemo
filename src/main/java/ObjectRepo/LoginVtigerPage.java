package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginVtigerPage {
	
	//initialization 
	public LoginVtigerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//element declaration
	@FindBy(name="user_name")
	private WebElement UserTextField;
	
	@FindAll({@FindBy(css = "[type='password']"),@FindBy(name = "user_password")})
	private WebElement PassWordTextField;
	
	@FindAll({@FindBy(xpath="//input[@type=\"submit\"]"),@FindBy(id = "submitButton")})
	private WebElement LoginButton;

	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPassWordTextField() {
		return PassWordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

//business logics
	//this method is used to login into vtiger applcation 
	
	public void loginIntoVtiger(String username,String password)
	{
	UserTextField.sendKeys(username);
	PassWordTextField.sendKeys(password);
	LoginButton.click();
		
	}
	
	

}
