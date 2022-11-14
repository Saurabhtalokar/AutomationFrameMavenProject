package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Base;
import util.Utilities;

public class HomePage extends Base {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement contact;
	
	@FindBy(xpath = "//a[@title='New Contact']")
	WebElement newContact;
	
	@FindBy(xpath = "//a[@title='Companies']")
	WebElement company;
	
	@FindBy(xpath = "//a[@title='New Company']")
	WebElement newCompany;
	
	@FindBy(xpath = "//a[@title='Deals']")
	WebElement deal;
	
	@FindBy(xpath = "//a[@title='New Deal']")
	WebElement newDeal;

	//Actions
public CreateContactPage contactlinkRedirection() {
	//Actions act = new Actions(driver);
	//act.moveToElement(contact).build().perform();
	Utilities.actionmouseover(contact);
	newContact.click();
	return new CreateContactPage();
	
}
public void companylinkRedirection(){
	//Actions act = new Actions(driver);
   //act.moveToElement(company).build().perform();
	Utilities.actionmouseover(company);
	newCompany.click();
}
public void deallinkRedirection(){
	//Actions act = new Actions(driver);
	//act.moveToElement(deal).build().perform();
	Utilities.actionmouseover(deal);
	newDeal.click();
}

}