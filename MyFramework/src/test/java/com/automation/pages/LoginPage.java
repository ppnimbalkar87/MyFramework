package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(id="user_login") WebElement username;
	@FindBy(id="user_pass") WebElement password;
	@FindBy(xpath="//input[@id='wp-submit']") WebElement loginButton;
	@FindBy(id="login_error") WebElement Login_Error;
	
	
	public void LoginToWordpress(String Uid,String Pass)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		username.clear();
		password.clear();
		username.sendKeys(Uid);
		password.sendKeys(Pass);
		loginButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean ValidateErrorMessage()
	{
		if(Login_Error.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
}
