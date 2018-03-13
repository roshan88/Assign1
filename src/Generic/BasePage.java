package Generic;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class BasePage
{
	
	 public WebDriver driver;
    public BasePage(WebDriver driver)
    {
    	this.driver=driver;    	
    }
    
    public void verifyElementPresent(WebElement elem)
    {
    	WebDriverWait wait= new WebDriverWait(driver,10);
    	try
    	{
    		wait.until(ExpectedConditions.visibilityOf(elem));
    	}
    	catch(Exception e)
    	{
    		Reporter.log("element not found",true);
    		Assert.fail();
    	}
    }
    
    public void verifytitlepresent(String  stri)
    {
    	WebDriverWait wait= new WebDriverWait(driver,10);
    	try
    	{
    		wait.until(ExpectedConditions.titleContains(stri));
    	}
    	catch(Exception e)
    	{
    		Reporter.log("Title not found",true);
    		Assert.fail();
    	}
    }
    
    public static void verifyLinkActive(String linkUrl) 
	{ 
    	try{
		URL url = new URL(linkUrl);
		HttpsURLConnection httpURLConnect = (HttpsURLConnection) url.openConnection();
		httpURLConnect.connect();
		
		if(httpURLConnect.getResponseCode()==200) {
			System.out.println(linkUrl+"_"+httpURLConnect.getResponseMessage());
		}
		
		if(httpURLConnect.getResponseCode()==HttpsURLConnection.HTTP_NOT_FOUND) {
			System.out.println(linkUrl+"_"+HttpURLConnection.HTTP_NOT_FOUND);
		}
    	}
    	catch(Exception e)
    	{
    		Reporter.log("url doesnt match",true);
    		Assert.fail();
    	}
	}
    
    
    public void takeScreenShootas(String arg)
    {
    	try
    	{
    	 String pathScreen="./Screens/"+System.currentTimeMillis()+".png";
    	 TakesScreenshot ts=(TakesScreenshot)driver;
    	 File scr= ts.getScreenshotAs(OutputType.FILE);
    	 File dst=new File(pathScreen);
       	}
    	catch(Exception e)
    	{
    		Reporter.log("invalue path");
    	}
    }

	 
    
    
}


