package hooksPackage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class HooksClass {

	
	
	@Before
	public void setup() {
		System.out.println("Before Scenario");
	}
	@Before("@Smoke")
	public void secondBefore() {
		System.out.println("secondBefore Scenario with TagName");
	}
	@After
	public void teamDown()
	{
		System.out.println("After Scenario");
	}
	
	
	/* we have another Hooks like
	 @BeforeStep and @AfterStep just like scenario they are executed after every method.
	 
	 We can use order into Method 
	 @Before(order=1)
	 we can user multiple before and after in hooks
	 
	 we can also give tag name into hooks
	 @Before("@smoke") now it will executed only when there is smoke test
	 
	  */
}
