package pages;

import org.openqa.selenium.By;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ex.ElementIsNotClickableException;

import utilities.Helper;
import utilities.TestData;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;

public class DemoqaFormPage {
	
	private TestData data= new TestData();
	private Helper helperObject= new Helper();
	
	private By firstName= By.xpath("//input[@id='firstName']");		
	private By lastName= By.xpath("//input[@id='lastName']");
	private By mobileNumber= By.xpath("//input[@id='userNumber']");
	private By male= By.xpath("//label[@class='custom-control-label' and text()='Male']");
	private By female= By.xpath("//label[@class='custom-control-label' and text()='Female']");
	private By otherGender= By.xpath("//label[@class='custom-control-label' and text()='Other']");
	private By submit= By.id("submit");
	private By verifySubmission= By.xpath("//div[@id='example-modal-sizes-title-lg']");
	
	public void fillForm()
	{
		data.firstName="Ihsan";
		$(firstName).setValue(data.firstName);
		data.lastName="Rehman";
		$(lastName).setValue(data.lastName);
		data.gender ="male";
		
		if(data.gender.equals("male")) {
			$(male).click();
		}
		else if(data.gender.equals("female")) {
			$(female).click();
		}
		else {
			$(otherGender).click();
		}
		
		data.mobileNumber="1234567890";
		$(mobileNumber).setValue(data.mobileNumber);
	}
	
	public void clickSubmit() throws InterruptedException {
		Selenide.executeJavaScript("window.scrollBy(0,1000)");
		try {
			$(submit).click();
//			To capture the exact values for color code we used Thread.sleep
			Thread.sleep(5000);
		}
		
		catch(ElementIsNotClickableException e){
			e.printStackTrace();
		}
					
	}
	
	public void verifyFormSubmit() {
		$(verifySubmission).shouldHave(text("Thanks for submitting the form"));
	}
	public String actuallColorCode(String element) {
				String actualColor=null;
		if(element.equals("firstName")) {
			actualColor=helperObject.getHexColor(firstName);
		}
		else if(element.equals("lastName")) {
			actualColor=helperObject.getHexColor(lastName);
		}
		else if(element.equals("gender")) {
			actualColor=$(male).getCssValue("color");
		}
		else if(element.equals("userNumber")) {
			actualColor=helperObject.getHexColor(mobileNumber);
		}
		return actualColor;
	}
	
}

