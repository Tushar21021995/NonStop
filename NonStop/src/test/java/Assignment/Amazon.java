package Assignment;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.GenericUtility.BaseClass;
import com.crm.GenericUtility.ExcelUtility;
import com.crm.GenericUtility.FileUtility;
import com.crm.GenericUtility.WebDriverUtility;

public class Amazon extends BaseClass
{
	@Test
	public void amazonTest() throws InterruptedException
	{

		WebDriverUtility wlib = new WebDriverUtility();

		wlib.maximizebrowser(driver);
		wlib.waitForPageLoad(driver);
		FileUtility plib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();


		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("WRIST WATCHES"); // searching for watch
		driver.findElement(By.id("nav-search-submit-button")).click();              // click on watches

		driver.findElement(By.xpath("//span[text()='Analogue']")).click();        // select analogue display
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Leather']")).click();         // selecting material
		Thread.sleep(2000);

		// code for selecting brand Titan
		driver.findElement(By.xpath("//a[@aria-label='See more, Brands']/descendant::i[@class='a-icon a-icon-extender-expand']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//li[@id='p_89/Titan']/descendant::span[text()='Titan']")).click();
		Thread.sleep(2000);

		// code for discount
		driver.findElement(By.xpath("//span[text()='25% Off or more']")).click();
		Thread.sleep(2000);

		// selecting 5th number watch
		driver.findElement(By.xpath("//div[@data-asin='B071DSTNFQ']")).click();
		Thread.sleep(2000);


		String pw = driver.getWindowHandle();
		wlib.switchToWindow(driver);

		driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']")).click();
		Thread.sleep(1000);

		driver.switchTo().window(pw);


		//selecting 8th number product
		driver.findElement(By.xpath("//div[@data-asin='B00DAHMXO6']")).click();

		String pw1=driver.getWindowHandle();
		wlib.switchToWindow(driver);

		driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']")).click();
		Thread.sleep(1000);

		driver.switchTo().window(pw1);
		// code for the clear data and search for apparel

		WebElement utb = driver.findElement(By.id("twotabsearchtextbox"));
		utb.sendKeys("WRIST WATCHES");
		utb.clear();
		utb.sendKeys("L and M size apparel");
		driver.findElement(By.id("nav-search-submit-button")).click(); 

		// check for product added in the cart and price are correct
		driver.findElement(By.xpath("//a[@id='nav-cart']")).click();

		List<WebElement> price = driver.findElements(By.xpath("//span[text()='1,874.00']"));
		for(int i=0;i<price.size();i++)
		{
			WebElement obj = price.get(i);
			String text = obj.getText();
			System.out.println(text);
		}


		List<WebElement> price1 = driver.findElements(By.xpath("//span[text()='1,478.00']"));
		for(int i=0;i<price.size();i++)
		{
			WebElement obj = price1.get(i);
			String text1 = obj.getText();
			System.out.println(text1);
		}


		if(price.equals(price1))
		{
			System.out.println("both price are not correct");
		}

		else
		{
			System.out.println("Both Price are correct and not greater than 3500 ");
		}

		// proceed to buy
		driver.findElement(By.xpath("//span[@id='sc-buy-box-ptc-button']")).click();

		driver.findElement(By.xpath("//i[@aria-label='Amazon']")).click();

		// delete the product from the cart
		driver.findElement(By.xpath("//a[@id='nav-cart']")).click();

		WebElement delete1 = driver.findElement(By.xpath("//input[@aria-label='Delete Titan Karishma Analog Champagne Dial Men&#39;s Watch-NL1580YL05/NP1580YL05']"));
		delete1.click();

		WebElement delete2 = driver.findElement(By.xpath("//input[@aria-label='Delete Titan Analog White Dial Men&#39;s Watch-NL1735SL01']"));
		delete2.click();

		// verifying product is empty
		if(delete1.equals(delete2))
		{
			System.out.println("Cart is Not Empty");
		}

		else
		{
			System.out.println("Cart is Emmpty");
		}

		// process for logout

		WebElement element = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
		wlib.mouseOverOnElement(driver, element);










	}

}
