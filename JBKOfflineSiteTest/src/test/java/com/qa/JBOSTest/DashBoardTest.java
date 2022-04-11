package com.qa.JBOSTest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.DashBoard;
import com.qa.Pages.LoginPage;
import com.qa.Pages.NewUserRegistration;
import com.qa.Pages.Users;

public class DashBoardTest extends TestBase {
	LoginPage lp;
	DashBoard db=new DashBoard();
	NewUserRegistration UserReg;
	Users userLink;
	WebElement usersLink;
	public DashBoardTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@BeforeMethod
	public void Setup() throws IOException {
		initialization();
		lp=new LoginPage();
		lp.login("kiran@gmail.com", "123456");
		
	}
	
	@Test(priority=1)
	public void verifyDashBoardPageTitleTest() throws IOException {
	
		String DBTitle=driver.getTitle();
		System.out.println(DBTitle);
		Assert.assertEquals(DBTitle,"JavaByKiran | Dashboard");		
	}

	@Test(priority=2)
	public void verifyCorrectUserNameTest() {
		
		String flag=db.verifyCorrectUserName();
		System.out.println(flag);
		Assert.assertEquals(flag,"Kiran");	
		//Assert.assertTrue(flag);	
	}
	
	
	@Test(priority=3)
	public void verifyUserLinkTest() throws IOException, InterruptedException {
		
		String tit=db.clickOnUsersLink();
		System.out.println(tit);
		Assert.assertEquals(tit,"JavaByKiran | User");	
		
	}
	

	@AfterMethod
	public void closeBrowser(){
		driver.quit();
		
	}
}
