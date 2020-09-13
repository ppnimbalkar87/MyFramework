package com.automation.testcases;

import java.util.concurrent.TimeUnit;

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
	
	@Test(dataProvider = "wordpressData",dataProviderClass = ExcelDataProvider.class)
	public void LoginApp(String Username,String Password)
	{		
		logger=report.createTest("Login To wordpress");
		LoginPage loginpage=PageFactory.initElements(driver	, LoginPage.class);
		logger.info("Starting Application");
		loginpage.LoginToWordpress(Username,Password);
		
		Assert.assertTrue(driver.getTitle().contains("Dashboard"),"Unable to Login");
		logger.pass("Login Succesfully");
	}
}
