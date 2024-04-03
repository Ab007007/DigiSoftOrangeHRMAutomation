package Orange;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeUtils extends DriverUtils {
	public void launch(String url) {
		System.out.println("launching the application using url");
		driver.get(url);
	}

	public void login(String un, String pwd) {
		System.out.println("login using valid credentials");
		type("name", "username", un);
		type("name", "password", pwd);
		click("xpath", "//button[@type='submit']");
		System.out.println("login successfully");
	}

	public void getmodule(String type) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		System.out.println("selecting a specific module type");
		switch (type) {
		case "Admin":
			wait.until(ExpectedConditions.elementToBeClickable(getelement("xpath", "//span[text()='Admin']"))).click();

			break;
		case "Pim":
			wait.until(ExpectedConditions.elementToBeClickable(getelement("xpath", "//span[text()='PIM']']"))).click();

			break;
		case "Leave":
			wait.until(ExpectedConditions.elementToBeClickable(getelement("xpath", "//span[text()='Leave']"))).click();

			break;
		case "Time":
			wait.until(ExpectedConditions.elementToBeClickable(getelement("xpath", "//span[text()='Time']"))).click();

			break;
		case "Recruitment":
			wait.until(ExpectedConditions.elementToBeClickable(getelement("xpath", "//span[text()='Recruitment']"))).click();
					

			break;
		case "My Info":
			wait.until(ExpectedConditions.elementToBeClickable(getelement("xpath", "//span[text()='My Info']"))).click();
					

			break;
		case "Performance":
			wait.until(ExpectedConditions.elementToBeClickable(getelement("xpath", "//span[text()='Performance']"))).click();
					

			break;
		case "Dashboard":
			wait.until(ExpectedConditions.elementToBeClickable(getelement("xpath", "//span[text()='Dashboard']"))).click();
					

			break;
		case "Directory":
			wait.until(ExpectedConditions.elementToBeClickable(getelement("xpath", "//span[text()='Directory']"))).click();
					

			break;
		case "Maintenance":
			wait.until(ExpectedConditions.elementToBeClickable(getelement("xpath", "//span[text()='Maintenance']"))).click();
					

			break;
		case "Claim":
			wait.until(ExpectedConditions.elementToBeClickable(getelement("xpath", "//span[text()='Claim']"))).click();

			break;
		case "Buzz":
			wait.until(ExpectedConditions.elementToBeClickable(getelement("xpath", "//span[text()='Buzz']"))).click();

			break;
		default:

			System.out.println("please check the module type");
			break;
		}

	}

	public void waitForSuccessMsgToComplete() {
		System.out.println("Waiting for the visibility of success msg");
		wait.until(ExpectedConditions
				.visibilityOf(getelement("xpath", "//div[@class='oxd-toast-content oxd-toast-content--success']/p")));

		System.out.println("Waiting for the In-visibility of success msg");
		wait.until(ExpectedConditions
				.invisibilityOf(getelement("xpath", "//div[@class='oxd-toast-content oxd-toast-content--success']/p")));
	}

	public void logout() {
		System.out.println("user logout from the application");
		getelement("xpath", "//p[@class='oxd-userdropdown-name']").click();
		getelement("xpath", "//a[text()='Logout']").click();
		System.out.println("logout successfully");
	}
	

}
