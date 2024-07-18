package auto.netbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[text()='New Customer']")
	@CacheLookup
	WebElement lnkAddNewCustomer;

	@FindBy(name = "name")
	@CacheLookup
	WebElement customerName;

	@FindBy(xpath = "//input[@value=\"f\"]")
	@CacheLookup
	WebElement Female;

	@FindBy(xpath = "//input[@value=\"m\"]")
	@CacheLookup
	WebElement Male;

	@FindBy(name = "dob")
	@CacheLookup
	WebElement dob;

	@FindBy(name = "addr")
	@CacheLookup
	WebElement Address;

	@FindBy(name = "city")
	@CacheLookup
	WebElement City;

	@FindBy(name = "state")
	@CacheLookup
	WebElement State;

	@FindBy(name = "pinno")
	@CacheLookup
	WebElement PinNo;

	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement MobileNumber;

	@FindBy(name = "emailid")
	@CacheLookup
	WebElement EmailID;

	@FindBy(name = "password")
	@CacheLookup
	WebElement Password;

	@FindBy(xpath = "//input[@value=\"Submit\"]")
	@CacheLookup
	WebElement Submit;

	public void clickNewCustomer() {
		lnkAddNewCustomer.click();
	}

	public void inputCustomerName(String name) {
		customerName.click();
		customerName.clear(); // Clear the field before entering text
		customerName.sendKeys(name);
	}

	public void clickFemale() {
		Female.click();
	}

	public void inputDOB(String dd, String mm, String yy) {
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yy);
	}

	public void inputAddress(String address) {
		Address.sendKeys(address);
	}

	public void inputCity(String city) {
		City.sendKeys(city);
	}

	public void inputState(String state) {
		State.sendKeys(state);
	}

	public void inputPinNo(String pinno) {
		PinNo.sendKeys(pinno);
	}

	public void inputMobileNo(String mobileno) {
		MobileNumber.sendKeys(mobileno);
	}

	public void inputEmailID(String emailid) {
		EmailID.sendKeys(emailid);
	}

	public void inputPassword(String password) {
		Password.sendKeys(password);
	}

	public void clickSubmit() {
		Submit.click();
	}
}