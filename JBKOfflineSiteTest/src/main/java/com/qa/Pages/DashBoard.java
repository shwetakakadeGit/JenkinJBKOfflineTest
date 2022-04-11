package com.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

public class DashBoard extends TestBase {

	LoginPage lp;
	public DashBoard() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	//Convert to DXpath
	
	//@FindBy(xpath = "/html/body/div/aside/section/div/div[2]")
	@FindBy(tagName="p")
	WebElement userNameLabel;
	
	
	
	public String verifyDashBoardPageTitle() throws IOException{
		lp=new LoginPage();
		lp.login("kiran@gmail.com", "123456");
		String DBTitle=driver.getTitle();
		System.out.println(DBTitle);
		return DBTitle;
	}
	public String verifyCorrectUserName(){
		String tit=driver.findElement(By.tagName("p")).getText();
	
		//String tit=userNameLabel.toString();
		System.out.println();
		return tit;
	}
	
	public String clickOnUsersLink() throws  InterruptedException{
		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
		//usersLink.click();
		driver.navigate().forward();
		Thread.sleep(100);
		String tit=driver.getTitle();
		System.out.println(tit);
		return tit;
	}
	
//	public Operators clickOnOperatorsLink(){
//		operatorsLink.click();
//		return new Operators();
//	}
//	public UsefulLinks clickOnUsefulLinks(){
//		usefulLink.click();
//		return new UsefulLinks();
//	}
//	public Downloads clickOnDownloadsLink(){
//		downloadLink.click();
//		return new Downloads();
//	}
//	
//	public Logout clickOnLogoutLink(){
//		downloadLink.click();
//		return new Logout();
//	}
//	
}
