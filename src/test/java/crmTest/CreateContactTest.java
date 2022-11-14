package crmTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CreateContactPage;
import pages.HomePage;
import pages.LoginPage;
import testBase.Base;
import util.Utilities;

public class CreateContactTest extends Base {
	LoginPage log;
	HomePage hp;
	CreateContactPage contactPage;

	@BeforeMethod
	public void initialization() {
		initialize();
		log= new LoginPage();
		hp=log.login(prop.getProperty("userName"),prop.getProperty("Password"));
		Utilities.swichtoMainpanelFrame();
		contactPage=hp.contactlinkRedirection();
	}
		
		
	
	@DataProvider(name = "ContactDataProviderDoc")
	public String [][] contactDataProvider() {
		String data[][]=Utilities.getData();
		return data;
	}
	
	
	@Test(dataProvider = "ContactDataProviderDoc")
	public void validateCreateContactTest(String name, String midleName, String surName,String companyName,String nickNam,String city) {
		//contactPage.createContact("Sachin", "Ramesh", "Tenadulkar", "Infosys", "Sachin", "Mumbai");
		contactPage.createContact(name, midleName, surName, companyName, nickNam, city);
		String contactCreateValidateText =contactPage.createContactValidationText();
		Assert.assertEquals(contactCreateValidateText, name +" "+ surName);
		
		
	}
	
	@AfterMethod
	public void closeResources() {
		log.logout();
		Assert.assertEquals(log.validateTitle(), "Free CRM - CRM software for customer relationship management, sales, and support.");
		driver.close();
		
	}
}
