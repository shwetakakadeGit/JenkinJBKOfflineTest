package com.qa.JBOSTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.DashBoard;
import com.qa.Pages.LoginPage;
import com.qa.Pages.NewUserRegistration;

public class NewUserRegistrationTest extends TestBase {
	LoginPage lp;
	DashBoard db;
	NewUserRegistration UserReg;
	@BeforeMethod
	public void Setup() throws IOException {
		initialization();
		UserReg= new NewUserRegistration();
	}

	public NewUserRegistrationTest() throws IOException {
		super();
	}

	@Test(priority=1)
	public void ValidateRegistrationSignInTextTest() throws IOException {
		
		boolean flag=UserReg.ValidateRegistraionSignInText();
		Assert.assertTrue(flag);		
	}
	@Test(priority=2)
	public void NewUserRegistrationTest() throws IOException, InterruptedException {
		
		String title=UserReg.fillRegistraionForm();
		
		Assert.assertEquals(title, "User registered successfully.");
		
	}
	@Test(priority=3)
	public void alreadyMemberRegisteredTest() throws InterruptedException {
		String title=UserReg.alreadyMember();
		Assert.assertEquals(title, "JavaByKiran | Log in");
		
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.quit();
		
	}

}
