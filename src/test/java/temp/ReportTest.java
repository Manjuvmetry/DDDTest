package temp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportTest {
	static WebDriver wd=null;
	ExtentReports report;
	ExtentTest log;
	@Test(priority=1)
	public void googleTest()
	{
		report=new ExtentReports("C:\\Seleniumworkspace\\DDDTest\\Report\\sample.html");
		wd=new FirefoxDriver();
		wd.get("http://www.google.com");
		log = report.startTest("GoogleTest");
		 
	}
	@Test(priority=2)
	public void yahooTest()
	{
		wd.get("http://www.yahoo.com");
		log = report.startTest("YahooTest");
	}
	@Test(priority=3)
	public void bingTest()
	{
		wd.get("http://www.bing.com");
		log = report.startTest("BingTest");
	}
	@AfterMethod
	public void tearDown(ITestResult it) throws IOException
	{
		if(it.isSuccess())
		{
			String path= takeScreenshot(it.getName());
			log.addScreenCapture(path);
			log.log(LogStatus.PASS, "Testcase Pass", path);
		}
		else
		{
			String path= takeScreenshot(it.getName());
			log.addScreenCapture(path);
			log.log(LogStatus.FAIL, "Testcase Fail", path);
		}
		report.endTest(log);
		report.flush();
		
	}
	public static  String takeScreenshot(String name) throws IOException
	{
		File src = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Seleniumworkspace\\DDDTest\\Screenshot\\"+name+".jpg");
		FileUtils.copyFile(src,dest);
		return dest.toString();
		
	}
}
