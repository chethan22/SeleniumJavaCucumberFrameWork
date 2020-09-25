package stepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.FileManager;
import generic.ScreenShot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.BugReport;
import pom.EnterTimeTrack;
import pom.Login_Page;

public class StepDefinations {
	WebDriver driver;
	FileManager fm = new FileManager();
	Login_Page lp;
	EnterTimeTrack ett;
	BugReport bg;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(fm.getImplictilyTime(), TimeUnit.SECONDS);
		driver.get(fm.getQatUrl());

		lp = new Login_Page(driver);
		ett = new EnterTimeTrack(driver);
		bg = new BugReport(driver);

	}

	@After
	public void tearDown(Scenario scenario) {
		String testName = scenario.getName();
		if (scenario.isFailed()) {
			new ScreenShot().capture(driver, testName);

		}
		driver.quit();
	}

	@Given("user is on login page")
	public void user_is_on_login_page() {

		System.out.println("user is successfully on login page");
	}

	@When("user enters valid username {string} and  password {string}")
	public void user_enters_valid_username_and_password(String un, String pword) {

		lp.setUserName(un);
		lp.setPassword(pword);
	}

	@When("clicks on login page")
	public void clicks_on_login_page() throws InterruptedException {
		lp.loginButton();

	}

	@Then("Message should be displayed as login Successfull {string}")
	public void message_should_be_displayed_as_login_successfull(String etitle) throws InterruptedException {

		Thread.sleep(2000);
		String atitle = driver.getTitle();
		Assert.assertEquals(etitle, atitle);
	}

	@When("clicks on help")
	public void clicks_on_help() {

		ett.clickHelp();

	}

	@When("clicks on About actime")
	public void clicks_on_about_actime() {

		ett.clickAboutActimeTime();
	}

	@When("verify the actime version {string}")
	public void verify_the_actime_version(String eVersion) {

		String aVersion = ett.actTimeVersion();
		Assert.assertEquals(eVersion, aVersion);
	}

	@When("user clicks on close")
	public void user_clicks_on_close() {

		ett.clickClose();
	}

	@When("user clicks on logout")
	public void user_clicks_on_logout() {

		ett.clickOnLogout();
	}

	@Then("login page should be displayed")
	public void login_page_should_be_displayed() {

		ett.verifyTitle("Login", 10);
		System.out.println(driver.getTitle());
	}

	@When("user clicks on report")
	public void user_clicks_on_report() {
		ett.clickReport();
		ett.switchWindow();
	}

	@When("user enters description {string}")
	public void user_enters_description(String issue) {
		bg.enterBugDescription(issue);
	}

	@When("user enters first name {string}")
	public void user_enters_first_name(String name) {
		bg.enterFirstName(name);
	}

	@When("user enters last name {string}")
	public void user_enters_last_name(String lname) {
		bg.enterLastName(lname);
	}

	@When("user enters email {string}")
	public void user_enters_email(String emailer) {
		bg.enterEmail(emailer);
	}

	@When("users enters company {string}")
	public void users_enters_company(String companyName) {
		bg.enterCompany(companyName);
	}

	@When("users clicks on send report")
	public void users_clicks_on_send_report() {
		bg.clickSendBugReport();
	}

	@Then("bug report should be submited successfully")
	public void bug_report_should_be_submited_successfully() {
		System.out.println("submitted successfully");
	}

}
