package com.vmetry.ntltaxi.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.IsAlertPresent;
import com.vmetry.ntltaxi.initializer.Initializer;



public class ReportOptimiser extends Initializer{
	
	@Test
	public static void archiveFiles() throws IOException
	{
		if(isArchive)
		{
		SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD hh-mm-ss-mmm");
		String path = df.format(new Date());
		File src = new File("C:\\Seleniumworkspace\\DDDTest\\Screenshot");
		File dest = new File("C:\\Seleniumworkspace\\DDDTest\\ArchiveFolder\\OLD"+path);
		FileUtils.copyDirectory(src, dest);
		FileUtils.cleanDirectory(src);//To clean the screenshot folder
		isArchive=false;
		}
		
	}
}
