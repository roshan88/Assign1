package Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public abstract class StandardVerification 
{
	public WebDriver driver;
	
	public StandardVerification(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void verifyPage(String atitle)
	{
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 try 
		 {
			wait.until(ExpectedConditions.titleContains(atitle));
			Reporter.log("the title is matching",true);
		} 
		 catch (Exception e) {
			 Reporter.log("title is not matching",true);
			// Assert.fail();
		}
	}
 
}
