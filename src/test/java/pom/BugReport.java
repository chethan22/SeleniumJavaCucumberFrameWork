package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Base_Page;

public class BugReport extends Base_Page {

	@FindBy(xpath = "//textarea[@id='bug']")
	private WebElement bugIssue;

	@FindBy(xpath = "//input[@class='first_name_field']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@id='emailAddress']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='companyName']")
	private WebElement company;

	@FindBy(xpath = "//input[@id='submitButton']")
	private WebElement bugReport;

	public BugReport(WebDriver driver) {
		super(driver);
	}

	public void enterBugDescription(String issue) {
		bugIssue.sendKeys(issue);
	}

	public void enterFirstName(String name) {
		firstName.sendKeys(name);
	}

	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void enterEmail(String emailer) {
		email.sendKeys(emailer);
	}

	public void enterCompany(String companyName) {
		company.sendKeys(companyName);
	}

	public void clickSendBugReport() {
		bugReport.click();
	}

}
