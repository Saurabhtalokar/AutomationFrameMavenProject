package pages;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.Base;
import util.Utilities;

public class CreateContactPage extends Base {

	public CreateContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Page object Repository
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id="middle_initial")
	WebElement middleName;
	
	@FindBy(id ="surname")
	WebElement lastName;
	
	@FindBy(name="suffix")
	WebElement suffix;
	@FindBy(name="nickname")
	WebElement nickName;
	@FindBy(name="client_lookup")
	WebElement company;
	@FindBy(xpath = "(//input[@value='Lookup'])[1]")
	WebElement companyLookup;
	@FindBy(xpath="//*[@id=\"search\"]")
	WebElement lookupSearch;
	@FindBy(xpath = "//*[@value=\"Search\"]")
	WebElement comSearch;
	@FindBy(linkText = "Infosys")
	WebElement selectCompanySugg;
	
	@FindBy(xpath = "(//input[@name='receive_email'])[1]")
	WebElement emailbutY;
	@FindBy(xpath = "(//input[@name='receive_email'])[2]")
	WebElement emailbutN;
	
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement address;
	
	@FindBy(xpath = "//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	WebElement save;
	
	@FindBy(xpath = "(//*[@class=\"tabs_header\"])[1]")
	WebElement contactValidationText;
	
	public void createContact(String name, String midleName, String surName,String companyName,String nickNam,String city) {
		String parentWindow =driver.getWindowHandle();
		Select select= new Select(title);
		select.selectByVisibleText("Mr.");
		firstName.sendKeys(name);
		middleName.sendKeys(midleName);
		lastName.sendKeys(surName);
		Select suffi= new Select(suffix);
		suffi.selectByValue("Sr.");
		companyLookup.click();
		//String parentWindow =driver.getWindowHandle();
		/*Set<String> childWindow =driver.getWindowHandles();
		
		for(String window:childWindow) {
			
			if(!parentWindow.contains(window)) {
				
				driver.switchTo().window(window);
				}
		}*/
		Utilities.windowHandlechild();
		driver.manage().window().maximize();
		lookupSearch.sendKeys(companyName);
		comSearch.click();
		selectCompanySugg.click();
		try {
		Thread.sleep(4000);
		}
		catch(Exception e) {
			System.out.println("Time is missing");
		}
		driver.switchTo().window(parentWindow);
		Utilities.swichtoMainpanelFrame();
		nickName.sendKeys(nickNam);
		
	//	String parentWindow =driver.getWindowHandle();
	//	driver.switchTo().window(parentWindow);
		emailbutN.click();
		if(!emailbutY.isSelected()) {
			emailbutY.click();
		}
		address.sendKeys(city);
		save.click();
	}
	
	public String createContactValidationText() {
		return contactValidationText.getText();
		
	}
	
	
}
