package com.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

public class LoginPage extends TestBase{

	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p[text()=\"Sign in to start your session\"]")
	WebElement signInText;
	
	@FindBy(id="email")
	WebElement usename;
	
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//*[@class=\"btn btn-primary btn-block btn-flat\"]")
	WebElement LoginBtn;
	
	@FindBy(xpath="// img[contains(@src,\"jbk.png\")]")
	WebElement jbkLogo;
	
	
	@FindBy(xpath="//a[contains(text(),\"Register a new membership\")]")
	WebElement newMember;
	
	public String validateLoginPage() {
		return driver.getTitle();
	}
	
	public boolean ValidateLoginPageLogo() {
		return jbkLogo.isDisplayed();
	}
	
	public boolean ValidateSignInText() {
		return signInText.isDisplayed();
	}
	
	public DashBoard login(String Un,String Pwd) throws IOException {
		usename.sendKeys(Un);
		password.sendKeys(Pwd);
		LoginBtn.click();
		return new DashBoard();
		
	}
	
	public String clickOnNewMemberLink(){
		newMember.click();
		return driver.getTitle();
	}
}
