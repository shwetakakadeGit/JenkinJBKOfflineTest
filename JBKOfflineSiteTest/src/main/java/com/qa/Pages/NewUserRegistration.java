package com.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

public class NewUserRegistration extends TestBase {

	public NewUserRegistration() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="name")
	WebElement name;
	
	@FindBy(xpath="//a[contains(text(),'Register a new membership') and@class=\"text-center\" ]")
	WebElement regSignInText;
	
	@FindBy(id="mobile")
	WebElement mobile;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//*[@type=\"submit\"and @class='btn btn-primary btn-block btn-flat']")
	WebElement signUpBtn;
	
	@FindBy(xpath="/html/body/div/div[2]/a")
	WebElement alreadyMemberLink;
	
	public boolean ValidateRegistraionSignInText() {
		return regSignInText.isDisplayed();
	}
	public String fillRegistraionForm() throws InterruptedException {
		regSignInText.click();;
		name.sendKeys("Shweta Kakade");
		Thread.sleep(200);
		mobile.sendKeys("1234567890");
		Thread.sleep(200);
		email.sendKeys("kakade.shweta@gmail.com");
		Thread.sleep(200);
		password.sendKeys("98765421");
		Thread.sleep(200);
		signUpBtn.click();
		Alert alert=driver.switchTo().alert();
		String alertMsg=alert.getText();
		return alertMsg;
	}
	
	public String alreadyMember() throws InterruptedException {
		alreadyMemberLink.click();
		driver.navigate().back();
		Thread.sleep(100);
		String backToLoginText=driver.getTitle();
		System.out.println(backToLoginText);
		return backToLoginText;
	}
}
