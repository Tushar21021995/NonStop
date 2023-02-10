package com.crm.GenericUtility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility 
{

	/**
	 * For pageload
	 * action to perform
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	/**
	 * For every browser it will maximize 
	 * action to perform
	 * @param Tushar
	 */
	public void maximizebrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	

	/**
	 * used to switch to any window based on window title
	 * @param driver
	 * @param PartialWindowTitle
	 * @author Tushar
	 */

	public void switchToWindow(WebDriver driver)
	{
		String pw = driver.getWindowHandle();
		Set<String> allhandles = driver.getWindowHandles();

		Iterator<String> it = allhandles.iterator();
		while(it.hasNext())
		{
			String win = it.next();
			if(!pw.equals(it))
			{
				driver.switchTo().window(win);
			}
		}
	}
	
	/**
	 * used to swtich to AlertWindow and accept(click on ok button)
	 * @author Tushar
	 */

	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	/**
	 * used to switch to AlertWindow and dissmis(click on cancel button)
	 * @author Tushar
	 */

	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

	
	/**
	 * used to switch to frame window based on index
	 *@param driver
	 *@param index
	 *@author Tushar
	 */

	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}

	/**
	 * used to switch to frame window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 * @author Tushar
	 */

	public void switchToFrame(WebDriver driver,String id_name_Attribute)
	{
		driver.switchTo().frame(id_name_Attribute);
	}
	
	/**
	 *  used to select the value from the dropdown based on index
	 * @param element
	 * @param index
	 * @author Tushar
	 */

	public void select(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}


	/**
	 * used to select the value from the dropdown based on text
	 * @param element
	 * @param text
	 * @author Tushar
	 */

	public void select(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * use to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 * @author Tushar
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}


	/**
	 * use to right click on specific element
	 * @param driver
	 * @param element
	 * @author Tushar
	 */

	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}





}
