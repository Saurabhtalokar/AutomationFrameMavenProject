package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Base;

public class LoginPage extends Base{
	
	//To initialize webElements
	public LoginPage() {
	PageFactory.initElements(driver, this);
		
	}
	//Page object repository
	
	//username text box
	@FindBy(name = "username")
	WebElement usernametxt;
	
	//username text box
	@FindBy(css = "[placeholder='Password']")
	WebElement passwordtxt;
	
	//loginbtn
	@FindBy(css = "[value='Login']")
	WebElement loginbtn;
	
	//Logo Validation
	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement logoValidate;
	
	//Title Validation
	@FindBy(linkText = "Free CRM  - CRM software for customer relationship management, sales, and support.")
	WebElement titleValidate;
	
	//Logout
	@FindBy(xpath = "/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[4]/a")
	WebElement logoutbtn;
	
	//actions
	
	public HomePage login(String userName, String Password) {
		usernametxt.sendKeys(userName);
		passwordtxt.sendKeys(Password);
		loginbtn.click();
	return new HomePage();
		
		
	}
	
	public boolean logoImgValidation() {
		boolean logo =logoValidate.isDisplayed();
		return logo;
	}
	
	public String validateTitle() {
		String title=driver.getTitle();
		return title;
	}
	
	public String logoutTextValidation() {
		String logouttex=logoutbtn.getText();
		return logouttex;
	}
	public void logout() {
		logoutbtn.click();
		
	}

}
