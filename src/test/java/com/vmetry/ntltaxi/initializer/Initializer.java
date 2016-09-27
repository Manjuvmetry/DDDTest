package com.vmetry.ntltaxi.initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vmetry.ntltaxi.utils.ReportOptimiser;

public class Initializer {
		public static FileInputStream envfis=null;
		public static Properties envprop=null;
		public static WebDriver wd = null;
		public static FileInputStream locfis=null;
		public static Properties locprop=null;
		public static ExtentReports report;
		public static ExtentTest log;
		public static boolean isArchive=true ;
		
		//@Test	
		public static void initialize() throws IOException
		{
			ReportOptimiser.archiveFiles();
			//To initialize the env file variables		
			envfis = new FileInputStream(new File("C:"+File.separator+"Seleniumworkspace"+File.separator+"DDDTest"+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"com"+File.separator+"vmetry"+File.separator+"ntltaxi"+File.separator+"config"+File.separator+"env.properties"));//Use File.properties instead of \\->For OS Compatibility
			envprop = new Properties();
			envprop.load(envfis);
			//To initialize the locator file variables										
			locfis = new FileInputStream(new File("C:"+File.separator+"Seleniumworkspace"+File.separator+"DDDTest"+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"com"+File.separator+"vmetry"+File.separator+"ntltaxi"+File.separator+"config"+File.separator+"locator.properties"));
			locprop = new Properties();
			locprop.load(locfis);
			
			report=new ExtentReports("C:\\Seleniumworkspace\\DDDTest\\Report\\DDD.html");
			
			System.out.println(envprop.getProperty("BROWSER"));
			//if(wd==null)
			if(envprop.getProperty("BROWSER").equals("Firefox"))
			{
				wd = new FirefoxDriver();
			}
			else if(envprop.getProperty("BROWSER").equals("Chrome"))
			{
				wd = new ChromeDriver();
			}
			wd.manage().window().maximize();
			wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		public static WebElement getWebelementByxpath(String xpath)
		{
			return wd.findElement(By.xpath(locprop.getProperty(xpath)));
		}

}
