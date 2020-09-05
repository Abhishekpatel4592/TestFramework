package com.framework.test.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.test.objectrepo.RegistrationObjectRepo;
import com.framework.test.util.RegistrationDataReader;

// Class to execute registration test case 
// Get test data from RegistrationDataReader
// Object Repository from RegistrationObjectRepo
public class RegistrationTest {

	WebDriver driver = null;
	RegistrationObjectRepo objectRepo = null;

	// Initiate the webdriver before test start
	@BeforeTest()
	public void initDriver() {
		
		// Define webdriver as chrome driver
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver");
		driver = new ChromeDriver();
		

		// Create object of Registration page (Page Object Model)
		objectRepo = new RegistrationObjectRepo(driver);

		// Clear Cookies of driver
		driver.manage().deleteAllCookies();

		// Set implicit timeout for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Getting URL
		driver.get("https://jsfiddle.net/xw0k21ed/1/");
	}

	// Close webdriver on completion of test
	@AfterTest
	public void closeDriver() {
		driver.close();
	}

	// Clear fields after each data row
	public void clearElements() {
		objectRepo.getFirstName().clear();
		objectRepo.getLastName().clear();
		objectRepo.getEmailId().clear();
	}

	// Handle the alert after
	public void manageAlert() throws InterruptedException {
		driver.switchTo().alert().accept();
		clearElements();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
	}

	// Main method to execute test cases and use excel file to provide test data
	@Test(dataProvider = "TestData", dataProviderClass = RegistrationDataReader.class, alwaysRun = true)
	public void testRegistrationData(String testCaseNo, String firstName, String lastName, String emailId,
			String expectedMessage) throws InterruptedException {
		
		

		// Enter to iframe
		driver.switchTo().frame(objectRepo.getMainFrame());
		objectRepo.getFirstName().sendKeys(firstName);
		objectRepo.getLastName().sendKeys(lastName);
		objectRepo.getEmailId().sendKeys(emailId);
		objectRepo.getSubmit().click();

		// Actual message from alerts
		String actualMessage = driver.switchTo().alert().getText();

		// Compare actual message with expected message
		if (actualMessage.equalsIgnoreCase(expectedMessage)) {
			System.out.println(testCaseNo + " Pass");
			manageAlert();
		} else {
			System.out.println(testCaseNo + " Fail because....");
			System.out.println("Actual Message :" + actualMessage + "\nExpected Message : " + expectedMessage);
			manageAlert();

			// Report failed test cases
			Assert.assertEquals(actualMessage, expectedMessage);
		}
	}
}
