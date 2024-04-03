package Orange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

public class UserManagementPage extends OrangeUtils {
	@FindBy(xpath = "//button[text()=' Add ']")
	WebElement addbutton;
	@FindBy(xpath = "//div[div[label[text()='User Role']]]")
	WebElement userselectdropdown;
	@FindBy(xpath = "//div[@role='listbox']")
	WebElement essselect;
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement employeename;
	@FindBy(xpath = "//div[@role='listbox']")
	WebElement employeeselect;
	@FindBy(xpath = "//div[div[label[text()='Status']]]")
	WebElement statusdropdown;
	@FindBy(xpath = "//div[@role='listbox']")
	WebElement enableselect;
	@FindBy(xpath = "//div[div[label[text()='Username']]]//input")
	WebElement usernamefield;
	@FindBy(xpath = "//div[div[label[text()='Password']]]//input")
	WebElement passwordfield;
	@FindBy(xpath = "//div[div[label[text()='Confirm Password']]]//input")
	WebElement confirmpasswordfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;

	public void add() {
		addbutton.click();

	}

	public void enterdetailes() {
		userselectdropdown.click();
		pauseexecution(2000);
		essselect.click();
		employeename.sendKeys("rakesh");
		pauseexecution(2000);
		employeeselect.click();
		statusdropdown.click();
		pauseexecution(2000);
		enableselect.click();
		usernamefield.sendKeys(new Faker().name().username());
		passwordfield.sendKeys("Passing@123123");
		confirmpasswordfield.sendKeys("Passing@123123");
		savebutton.click();

	}

	public UserManagementPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
