package com.automation.testcases;

import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pages.Baseclass;
import com.automation.pages.LoginPage;
import com.automation.utility.BrowserFactory;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;

public class LoginTest extends Baseclass {
	
	@Test(priority = 2,dataProvider = "wordpressData",dataProviderClass = ExcelDataProvider.class)
	public void ValidLoginApp(String Username,String Password)
	{		
		logger=report.createTest("Login To wordpress");
		LoginPage loginpage=PageFactory.initElements(driver	, LoginPage.class);
		logger.info("Starting Application");
		loginpage.LoginToWordpress(Username,Password);
		String title=driver.getTitle();
//		Assert.assertTrue(driver.getTitle().contains("Dashboard"),"Unable to Login");
		if(title.contains("Dashboard"))
		{
			logger.pass("Login Succesfully for valid username");
		}
		else
		{
			if(loginpage.ValidateErrorMessage())
			{
				logger.fail("Login Unuccesfully for invalid username Or password");
			}
		}
	}

	@Test(priority = 1,dataProvider = "wordpressData",dataProviderClass = ExcelDataProvider.class)
	public void InalidLoginApp(String Username,String Password)
	{		
		logger=report.createTest("Login To wordpress");
		LoginPage loginpage=PageFactory.initElements(driver	, LoginPage.class);
		logger.info("Starting Application");
		loginpage.LoginToWordpress(Username,Password);
		String title=driver.getTitle();
//		Assert.assertTrue(driver.getTitle().contains("Dashboard"),"Unable to Login");
		if(title.contains("Dashboard"))
		{
			logger.fail("Login Succesfully for Invalid username");
		}
		else
		{
			if(loginpage.ValidateErrorMessage())
			{
				logger.pass("Login Unuccesfully for invalid username Or password");
			}
		}
	}
}
