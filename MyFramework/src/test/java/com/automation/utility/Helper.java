package com.automation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String CaptureScreenshot(WebDriver driver) 
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
		String ScreenshotPath=System.getProperty("user.dir")+"/Screenshots/Wordpress_"+getCurrentDateTime()+".png";
		try {
			FileHandler.copy(src, new File(ScreenshotPath));
			System.out.println("Screenshot Captured");
			
		} catch (Exception e) {
			System.out.println("Unable to capture Screenshot>>"+e.getMessage());
		}
		return ScreenshotPath;
	}
	
	public static String getCurrentDateTime()
	{
		SimpleDateFormat Customformat=new SimpleDateFormat("MM_dd_yy_Hh_mm_ss");
		Date cuurentDate=new Date();
		return Customformat.format(cuurentDate);
	}

}
