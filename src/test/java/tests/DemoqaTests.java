package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.DemoqaFormPage;
import pages.DemoqaPage;

public class DemoqaTests extends TestBase {
	
	DemoqaPage demoqaObject=new DemoqaPage();
	DemoqaFormPage formPageObject=new DemoqaFormPage();

	@BeforeMethod(alwaysRun=true)
	public void SetUp() throws Exception {
		initilizeDemoqa();
	}
		
	@Test
	public void verifyFormSubmission() throws Exception {
		demoqaObject.navigateToFourm();
		demoqaObject.clickPractiseForm();
		formPageObject.fillForm();
		formPageObject.clickSubmit();
		formPageObject.verifyFormSubmit();
	}
	
	@Test
	public void verifyRequiredField() throws Exception {
		String expectedColorCodeFname= "#dc3545";
		String expectedColorCodeLname= "#dc3545";
		String expectedColorCodeGender= "rgba(220, 53, 69, 1)";
		String expectedColorCodeNumber= "#dc3545";
		String actual= null;
		demoqaObject.navigateToFourm();
		demoqaObject.clickPractiseForm();
		formPageObject.clickSubmit();
		actual=formPageObject.actuallColorCode("firstName");
		Assert.assertEquals(actual, expectedColorCodeFname);
		actual=formPageObject.actuallColorCode("lastName");
		Assert.assertEquals(actual, expectedColorCodeLname);
		actual=formPageObject.actuallColorCode("gender");
		Assert.assertEquals(actual, expectedColorCodeGender);
		actual=formPageObject.actuallColorCode("userNumber");
		Assert.assertEquals(actual, expectedColorCodeNumber);				
	}
}
