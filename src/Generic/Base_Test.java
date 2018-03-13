package Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class Base_Test implements AutoConst
{
	public WebDriver driver;
	
  @BeforeMethod
  //String Url
  public void openApp()
  {
	  System.setProperty(gecko_key,gecko_key);
	  String Url="https://www.bankbazaar.com/credit-score.html?utm_source=bb&utm_medium=display&utm_campaign=HEADER";
	  driver.get(Url);
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
  }
 
  
  @AfterMethod
  public void closapp()
  {
	  driver.close();
  }
	
	
}
