package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	//initilisation
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// declaration
	@FindBy(xpath="//a[text()='Mobiles']")
	private WebElement mobilesbutton;

	
	
	
	// utilizations
	
	public WebElement getMobilesbutton()
	{
		return mobilesbutton;
	}
	
	// buisness logics
	/**
	 * used for homepage app
	 * @param mobiles
	 * @author Tushar
	 */
	
	public void mobiles()
	{
		mobilesbutton.click();
		
	}

	
}
