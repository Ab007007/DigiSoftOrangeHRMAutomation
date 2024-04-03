package Orange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage extends OrangeUtils {

	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameTextBox;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordTextBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	
	public void login(String name, String pwd) {

		userNameTextBox.sendKeys(name);
		passwordTextBox.sendKeys(pwd);
		loginButton.click();
	}

	public OrangeHRMLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
