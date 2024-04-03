package Orange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMDashboardPage extends OrangeUtils {
	@FindBy(xpath = "//i[@class='oxd-icon bi-stopwatch']")
	WebElement attendence;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement inbutton;
	@FindBy(xpath = "//textarea[@placeholder='Type here']")
	WebElement textarea;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement outbutton;

	public void punchin() {
		attendence.click();
		textarea.sendKeys("InTime");
		//inbutton.click();

	}

	public void punchout() {
		attendence.click();
		textarea.sendKeys("OutTime");
		pauseexecution(2000);
		outbutton.click();
	}

	public OrangeHRMDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
