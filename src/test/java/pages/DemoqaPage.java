package pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;

public class DemoqaPage {
	
	private By forms= By.xpath("(//div[@class='avatar mx-auto white'])[2]");		
	private By practiseForms= By.xpath("(//ul[@class='menu-list']/li[1])[2]");
	
	public void navigateToFourm() {
		Selenide.executeJavaScript("window.scrollBy(0,200)");
		$(forms).click();
	}
	
	public void clickPractiseForm() {
		$(practiseForms).click();
	}
}
