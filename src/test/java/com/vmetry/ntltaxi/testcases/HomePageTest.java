package com.vmetry.ntltaxi.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vmetry.ntltaxi.initializer.Initializer;
import com.vmetry.ntltaxi.inputreader.inputReader;
import com.vmetry.ntltaxi.pages.HomePage;
import com.vmetry.ntltaxi.utils.ScreenshotGenerator;

public class HomePageTest extends Initializer {
	@BeforeTest 
	public void setUp() throws IOException
	{
		initialize();
	}
	@Test(dataProvider="HomePageTest")
	public void validateHomepage(String testdata,String username,String mobileno,String pickaddr,String dropaddr,String basic) throws IOException
	{
		log=report.startTest(testdata);
		HomePage.enterusername(username);
		HomePage.entermobileno(mobileno);
		HomePage.enterpickaddr(pickaddr);
		HomePage.enterdropaddr(dropaddr);
		HomePage.selectbasic(basic);
		HomePage.clickbooklater();	
	}
	@DataProvider(name="HomePageTest")
	public static Object[][] getHomePageData() throws Exception
	{
		if(inputReader.RunModeVerification("HomePageTest"))
		{
			Object[][] data = inputReader.selectSingleDataOrMulitiData("HomePageTest");
			return data;
		}
		return null;
	}
	@AfterMethod
	public void tearDown(ITestResult it) throws IOException
	{
		ScreenshotGenerator.generateScreenshot(it);
	}
}


//wd.get(envprop.getProperty("URL"));
/*wd.findElement(By.xpath(locprop.getProperty("HOMEPAGE_USERNAME_TYPE_XPATH"))).sendKeys("manju");
wd.findElement(By.xpath(locprop.getProperty("HOMEPAGE_MOBILENO_TYPE_XPATH"))).sendKeys("9176142940");
wd.findElement(By.xpath(locprop.getProperty("HOMEPAGE_PICKADDR_TYPE_XPATH"))).sendKeys("Thiruvottriyur");
wd.findElement(By.xpath(locprop.getProperty("HOMEPAGE_DROPADDR_TYPE_XPATH"))).sendKeys("Adyar");
wd.findElement(By.xpath(locprop.getProperty("HOMEPAGE_BASIC_SELECT_XPATH"))).sendKeys("Sedan");
wd.findElement(By.xpath(locprop.getProperty("HOMEPAGE_BOOKLATER_CLICK_XPATH"))).click();*/


/*Object[][] data = new Object[3][6];
data[0][0] = "HomePageTest_Dataset1";
data[0][1]="TestA";
data[0][2]="9876542323";
data[0][3]="ADYAR";
data[0][4]="ADYAR";
data[0][5]="Sedan";

data[1][0] = "HomePageTest_Dataset2";
data[1][1]="TestB";
data[1][2]="9876542323";
data[1][3]="ADYAR";
data[1][4]="ADYAR";
data[1][5]="Sedan";

data[2][0] = "HomePageTest_Dataset3";
data[2][1]="TestC";
data[2][2]="9876542323";
data[2][3]="ADYAR";
data[2][4]="ADYAR";
data[2][5]="Sedan";*/
