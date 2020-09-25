package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Base_Page;

public class EnterTimeTrack extends Base_Page {

	@FindBy(xpath = "//div[@class='popup_menu_icon support_icon']")
	private WebElement help;

	@FindBy(xpath = "//a[contains(.,'About actiTIME')]")
	private WebElement aboutActime;

	@FindBy(xpath = "//span[contains(.,'actiTIME 2014 Pro')]")
	private WebElement aVersion;

	@FindBy(xpath = "//td[@class='close-button']//img")
	private WebElement close;
	
	@FindBy(xpath = "//a[contains(.,'Report a Bug to Vendor')]")
	private WebElement report;

	@FindBy(id = "logoutLink")
	private WebElement logout;

	public EnterTimeTrack(WebDriver driver) {
		super(driver);
	}

	public void clickHelp() {
		help.click();
	}

	public void clickAboutActimeTime() {
		aboutActime.click();
	}

	public String actTimeVersion() {
		return aVersion.getText();

	}

	public void clickClose() {
		close.click();
	}
	
	public void clickReport() {
		report.click();
	}

	public void clickOnLogout() {
		logout.click();
	}

}
