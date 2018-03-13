
package Scripts;


import org.testng.annotations.Test;

import Generic.BasePom1;
import Generic.Standard_Test;

public class BaseTest1 extends Standard_Test
{

	@Test
	public void test1()
	{
		BasePom1 bp = new BasePom1(driver);
	//	String pageTitle=driver.getTitle();
	//
		//bp.verify(pageTitle);
		
		
	}
}
