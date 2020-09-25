package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Base_Page;

public class Login_Page extends Base_Page {

	@FindBy(id = "username")
	private WebElement userNameTextFeild;

	@FindBy(name = "pwd")
	private WebElement passwordTextFeild;

	@FindBy(xpath = "//div[.='Login ']")
	private WebElement login;

	public Login_Page(WebDriver driver) {

		super(driver);
	}

	public void setUserName(String name) {

		userNameTextFeild.sendKeys(name);
	}

	public void setPassword(String pword) {

		passwordTextFeild.sendKeys(pword);
	}

	public void loginButton() {
		login.click();
	}

}
