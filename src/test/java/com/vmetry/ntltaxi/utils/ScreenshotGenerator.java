package com.vmetry.ntltaxi.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.vmetry.ntltaxi.initializer.Initializer;

public class ScreenshotGenerator extends Initializer{

	public static void generateScreenshot(ITestResult it) throws IOException
	{
		Object[] data = it.getParameters();
		if(it.isSuccess())
		{
			String path= takeScreenshot(data[0].toString());
			System.err.println(path);
			log.addScreenCapture(path);
			log.log(LogStatus.PASS, "Testcase Pass", path);
		}
		else
		{
			String path= takeScreenshot(data[0].toString());
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

