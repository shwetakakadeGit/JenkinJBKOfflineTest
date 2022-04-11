package com.qa.JBOSTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.DashBoard;
import com.qa.Pages.LoginPage;
import com.qa.Pages.NewUserRegistration;


public class LoginPageTest extends TestBase{
	LoginPage lp;
	DashBoard db;
	
	NewUserRegistration UserReg;
	@BeforeMethod
	public void Setup() throws IOException {
		initialization();
		lp= new LoginPage();
	}
	
	public LoginPageTest() throws IOException {
		super();
		
	}
	
	
	
	@Test(priority=1)
	public void ValidateSignInTextTest() throws IOException {
		
		boolean flag=lp.ValidateSignInText();
		Assert.assertTrue(flag);		
	}
	
	@Test(priority=2)
	public void LoginPageTitleTest() throws IOException {
		
		String title=lp.validateLoginPage();
		Assert.assertEquals(title, "JavaByKiran | Log in");
		
	}
	
	@Test(priority=3)
	public void ValidUserTest() throws IOException {
		String Unm=prop.getProperty("username");
		String pwd=prop.getProperty("password");
		System.out.println("SSSS");
		db=lp.login(Unm,pwd);
		
	}
	
	@Test(priority=4)
	public void ValidNewMemberRegistrationLink() {
		String title1=lp.clickOnNewMemberLink();
		Assert.assertEquals(title1, "JavaByKiran | Registration Page");
	}
	@AfterMethod
	public void closeBrowser(){
		driver.quit();
		
	}
}
