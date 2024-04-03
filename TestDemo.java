package Orange;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class TestDemo extends OrangeUtils {

	OrangeHRMLoginPage loginpage;
	OrangeHRMDashboardPage dashpage;
	UserManagementPage umpage;

	@BeforeTest
	public void presetup() {

		getdriver("chrome");
		test = reports.createTest("Setup : Pre condition to my Test ");
		test.log(Status.INFO, "Creating a Driver object ");
		test.log(Status.INFO, "Driver Created Successfully ");
		test.log(Status.INFO, "Launching the Application ");
		launch("http://localhost/orange");
		test.log(Status.PASS, "Launching the Application Successfull ");

		loginpage = new OrangeHRMLoginPage(driver);
		dashpage = new OrangeHRMDashboardPage(driver);
		umpage = new UserManagementPage(driver);
		test.log(Status.INFO, "Login the Application ");
		loginpage.login("Admin", "Rakesh@1515");
		test.log(Status.PASS, "Login the Application Successfull ");

	}

	@BeforeMethod
	public void in() {
		dashpage.punchin();
	}

	@Test
	public void createuser() {
		getmodule("Admin");
		pauseexecution(3000);
		umpage.add();
		test.log(Status.INFO, "Creating a new user ");
		umpage.enterdetailes();
	}

	@AfterMethod
	public void out() {
		getmodule("Dashboard");
		dashpage.punchout();
	}

	@AfterTest
	public void cleanup() {
		loginpage = null;
		dashpage = null;
		umpage = null;
		logout();
		test.log(Status.INFO, "logout successfully");
	}
}