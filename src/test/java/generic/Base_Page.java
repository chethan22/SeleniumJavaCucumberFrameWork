package generic;

import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Page {
	WebDriver driver;

	public Base_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyTitle(String title, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.titleContains(title));
			System.out.println("valid title");
		} catch (Exception e) {
			System.out.println("invalid Title");
			Assert.fail();
		}
	}
	
	public void verifyElement(WebElement elemnet,int time) {
		WebDriverWait wait =new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.visibilityOf(elemnet));
			System.out.println("Element is visible");
		} catch (Exception e) {
			System.out.println("element is not vissible");
			Assert.fail();
		}
	}
	
	public void switchWindow() {
		
		Set<String> all_Window = driver.getWindowHandles();
		for (String wind : all_Window) {
			
			driver.switchTo().window(wind);
		}
	}

}
