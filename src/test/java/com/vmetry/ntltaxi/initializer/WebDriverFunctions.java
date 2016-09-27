package com.vmetry.ntltaxi.initializer;

import org.openqa.selenium.support.ui.Select;



public class WebDriverFunctions extends Initializer{
	public static void selectDropdownByVisibletext(String xpath,String option)
	{
		Select s = new Select(getWebelementByxpath(xpath));
		s.selectByVisibleText(option);
	}
}
