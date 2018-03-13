package Generic;

import org.openqa.selenium.WebDriver;

public class BasePom1 extends StandardVerification
{

	public BasePom1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void verify(String page)
	{
		verifyPage(page);
	}

}
