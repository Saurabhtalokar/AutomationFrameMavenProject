package crmTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testBase.Base;
import util.Utilities;

public class HomePageTest extends Base {
	LoginPage log;
	HomePage hp;
	
	@BeforeMethod
	public void initialization() {
		initialize();
		log= new LoginPage();
		//hp= new HomePage();
		
		hp=log.login(prop.getProperty("userName"),prop.getProperty("Password"));
		Utilities.swichtoMainpanelFrame();
		
	}
	
	@Test
	public void validateContactLinkRedirection() {
		hp.contactlinkRedirection();
		String createNewContactTitle=log.validateTitle();
		Assert.assertEquals(createNewContactTitle, "CRMPRO");
	}
	
	
	@Test
	public void validatecompanyLinkRedirection() {
		hp.companylinkRedirection();
		String createNewCompanyTitle=log.validateTitle();
		Assert.assertEquals(createNewCompanyTitle, "CRMPRO");
	}
	
	
	@Test
	public void validatedealLinkRedirection() {
		hp.deallinkRedirection();
		String createNewdealTitle=log.validateTitle();
		Assert.assertEquals(createNewdealTitle, "CRMPRO");
	}
	
	@AfterMethod
	public void closeResources() {
		log.logout();
		Assert.assertEquals(log.validateTitle(),"Free CRM - CRM software for customer relationship management, sales, and support.");
		driver.close();
	}
	
}
