package com.vmetry.ntltaxi.pages;

import org.openqa.selenium.WebDriver;

import com.vmetry.ntltaxi.initializer.Initializer;
import com.vmetry.ntltaxi.initializer.WebDriverFunctions;

public class HomePage extends Initializer {
	public static void enterusername(String username)
	{
		getWebelementByxpath("HOMEPAGE_USERNAME_TYPE_XPATH").sendKeys(username);
	}
	public static void entermobileno(String mobileno)
	{
		getWebelementByxpath("HOMEPAGE_MOBILENO_TYPE_XPATH").sendKeys(mobileno);
	}
	public static void enterpickaddr(String pickaddr)
	{
		getWebelementByxpath("HOMEPAGE_PICKADDR_TYPE_XPATH").sendKeys(pickaddr);
	}
	public static void enterdropaddr(String dropaddr)
	{
		getWebelementByxpath("HOMEPAGE_DROPADDR_TYPE_XPATH").sendKeys(dropaddr);
	}
	public static void selectbasic(String basic)
	{
		WebDriverFunctions.selectDropdownByVisibletext("HOMEPAGE_BASIC_SELECT_XPATH", basic);
	}
	public static void clickbooklater()
	{
		getWebelementByxpath("HOMEPAGE_BOOKLATER_CLICK_XPATH").click();
	}
	

}
