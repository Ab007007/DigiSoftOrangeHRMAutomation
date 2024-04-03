package Orange;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils {
	public WebDriver driver;
	WebDriverWait wait;
	public static ExtentReports reports = null;
	public static ExtentTest test = null;
	public static ExtentSparkReporter spark=null;
	
	@BeforeSuite
	public void conigureReports()
	{
		String date = new Date().toString().replace(":", "_").replace(" " , "_");
		 spark = new ExtentSparkReporter("reports/ExtentReport_" + date + ".html");
		reports = new ExtentReports();
		reports.attachReporter(spark);
		test=reports.createTest("orangehrm");

		System.out.println("Creating Repoerts");
	}

	@AfterSuite
	public void closereports() {
		test.log(Status.INFO, "save the reports");
		reports.flush();
	}
/**
 * @author Rakesh
 * @param "chrome","ff","edge"
 * @return WebDriver
 */
	public WebDriver getdriver(String type) {
		test.log(Status.INFO, "create driver object");
		switch (type.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromiumdriver().setup();
			driver = new ChromeDriver();

			break;
		case "ff":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			break;

		default:
			driver = null;
			System.out.println("please check the driver");
			break;
		}
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 30);
		return driver;
	}
	/**
	 * @author Rakesh
	 * @param "id","name","classname","tagname","css","xpath","plink","link"
	 * @return WebElement
	 */

	public WebElement getelement(String identifiers, String value) {
		System.out.println("finding a element using " + identifiers + "value" + value);
		test.log(Status.INFO, "finding a element using " + identifiers + "value" + value);
		WebElement ele;
		switch (identifiers.toLowerCase()) {
		case "id":
			ele = driver.findElement(By.id(value));
			break;
		case "name":
			ele = driver.findElement(By.name(value));
			break;
		case "classname":
			ele = driver.findElement(By.className(value));
			break;
		case "tagname":
			ele = driver.findElement(By.tagName(value));
			break;
		case "linktext":
			ele = driver.findElement(By.linkText(value));
			break;
		case "partiallinktext":
			ele = driver.findElement(By.partialLinkText(value));
			break;
		case "css":
			ele = driver.findElement(By.cssSelector(value));
			break;
		case "xpath":
			ele = driver.findElement(By.xpath(value));
			break;

		default:
			ele = null;
			System.out.println("please check the identifires and value");
			break;
		}

		return ele;
	}

	public void type(String identifiers, String value, String texttoentr) {
		getelement(identifiers, value).sendKeys(texttoentr);
	}

	public void click(String identifiers, String value) {
		getelement(identifiers, value).click();
	}

	public void pauseexecution(int ms) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String gettext(String identifiers, String value) {
		return getelement(identifiers, value).getText();
	}

	public String getAttributetext(String identifiers, String value, String attributevalve) {
		return getelement(identifiers, value).getAttribute(attributevalve);
	}

	public String getdateandtime() {
		return new Date().toString().replace(" ", "_").replace(":", "_");
	}

	public void takescreenshot(String testname) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File("Sceenshot//" + testname + getdateandtime() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void gettittle() {
		Assert.assertEquals("expected result", driver.getTitle());
	}

}