package com.crm.GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public WebDriver driver=null;
	
	FileUtility plib=new FileUtility();
	
	@BeforeSuite()
	public void BS()
	{
		System.out.println("Connect to Data Base");
	}
	
	@BeforeTest()
	public void BT()
	{
		System.out.println("Execute Script in paraller mode");
	}
	
	@BeforeClass()
	public void BC() throws IOException
	{
		String Browser = plib.getPropertyKeyvalue("browser");
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
		else if(Browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		else
		{
			driver=new ChromeDriver();
		}
		
		System.out.println("Launching The Browser");
	}
	
	@BeforeMethod()
	public void BM() throws IOException
	{
		String Url = plib.getPropertyKeyvalue("url5");
		
		driver.get(Url);
		
		System.out.println("Log in to the application");
	}
	
	
	@AfterMethod()
	public void AM()
	{
		System.out.println("Logout from the application");
	}
	
	@AfterClass()
	public void AC()
	{
		System.out.println("Close the browser");
	}

	@AfterTest()
	public void AT()
	{
		System.out.println("Parallel Execution Done");
	}
	
	@AfterSuite()
	public void AS()
	{
		System.out.println("Disconnect database connection");
	}
	


}
