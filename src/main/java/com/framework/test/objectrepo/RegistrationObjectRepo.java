package com.framework.test.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Page Object Model (Object Repository)
public class RegistrationObjectRepo {

	WebDriver driver;

	public RegistrationObjectRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//iframe[@src='//fiddle.jshell.net/xw0k21ed/1/show/?editor_console=']")
	WebElement mainFrame;
	
	@FindBy(id = "firstName")
	WebElement firstName;

	@FindBy(id = "lastName")
	WebElement lastName;

	@FindBy(id = "emailAddress")
	WebElement emailId;

	@FindBy(id = "bySubmit")
	WebElement submit;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getMainFrame() {
		return mainFrame;
	}
}
//Change
