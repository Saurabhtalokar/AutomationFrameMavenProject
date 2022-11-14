package crmTest;

import org.openqa.selenium.interactions.Action;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import pages.LoginPage;
import testBase.Base;

public class LoginPageTest extends Base {
	
	LoginPage log;
	
	@BeforeMethod
	public void initialization() {
		initialize();
		log = new LoginPage();
		
		
	}
	
	
	
	@Test(priority = 3)
	public void loginPage() {
		log.login(prop.getProperty("userName"),prop.getProperty("Password"));
		driver.switchTo().frame("mainpanel");
		String logtext =log.logoutTextValidation();
		System.out.println(logtext);
		
		Assert.assertEquals(logtext, "  Logout  ");
		
	}
	
	@Test(priority = 2)
	public void validateLogoTest() {
		boolean img=log.logoImgValidation();
		System.out.println(img);
		Assert.assertEquals(img, true);
	}
	
	@Test(priority = 1)
	public void validateTitlePage() {
		String titl =log.validateTitle();
		System.out.println(titl);
		Assert.assertEquals(titl, "Free CRM - CRM software for customer relationship management, sales, and support.");
	}
	
	
	
	@AfterMethod
	public void colseResources() {
		colse();
		
	}
	
	
	
}
