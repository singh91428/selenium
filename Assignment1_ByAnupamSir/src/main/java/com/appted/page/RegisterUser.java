package com.appted.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appted.actions.ActionsOnWebElements;
import com.appted.data.GetData;
import com.appted.data.Xls_Reader;

public class RegisterUser extends ActionsOnWebElements{
	WebDriver driver;
	String path="D:\\Autimation_Suite2.xlsx";
	Xls_Reader obj=new Xls_Reader(path);
	public RegisterUser(WebDriver driver) {
		this.driver=driver;
	}
	
	//  ====================FirstPart=============================
	
	@FindBy(xpath = "//*[@id=\'header\']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	@FindBy(xpath = "//*[@id=\'email_create\']")
	WebElement emailInput;
	
	@FindBy(xpath = "//*[@id=\'SubmitCreate\']")
	WebElement createanAccountBtn;
	
	
	//======================================
	
	@FindBy(id = "id_gender1")
	WebElement userTitle;
	
	@FindBy(xpath = "//*[@id=\'customer_firstname\']")
	WebElement firstnameInput;
	
	@FindBy(xpath = "//*[@id=\'customer_lastname\']")
	WebElement lastnameInput;
	
	@FindBy(xpath = "//*[@id=\'passwd\']")
	WebElement passInput;
	
	@FindBy(xpath = "//*[@id=\'days\']")
	WebElement days;
	
	@FindBy(xpath = "//*[@id=\'months\']")
	WebElement month;
	
	@FindBy(xpath = "//*[@id='years']")
	WebElement year;
	
	@FindBy(xpath = "//*[@id=\'firstname\']")
	WebElement addressFirstname;
	
	@FindBy(xpath = "//*[@id=\'lastname\']")
	WebElement addressLastname;
	
	@FindBy(xpath = "//*[@id=\'company\']")
	WebElement addressCountry;
	
	@FindBy(xpath ="//*[@id=\'address1\']")
	WebElement addressAddress;
	
	//=============================
	
	@FindBy(xpath ="//*[@id=\'city\']")
	WebElement addressCityInput;
	
	@FindBy(id="id_state")
	WebElement addressStatedd;
	
	@FindBy(xpath ="//*[@id=\'postcode\']")
	WebElement addressZipInput;
	
	@FindBy(id="id_country")
	WebElement addressCountrydd;
	
	@FindBy(id="other")
	WebElement addressAddInforTa;
	
	@FindBy(id="phone")
	WebElement addressPhoneInput;
	
	@FindBy(id="phone_mobile")
	WebElement addressPhoneMobInput;
	
	@FindBy(id="alias")
	WebElement addressAliasInput;
	
	@FindBy(id="submitAccount")
	WebElement registerBtn;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")
	WebElement registerSuccess;
	
	@FindBy(id="create_account_error")
	WebElement emailError;
	
	@FindBy(xpath="//*[@id=\'center_column\']/div/p")
	WebElement mandatoryFielsError;
	
	String email=obj.getCellData("Data",1,2);
	String firstName=obj.getCellData("Data",2,2);
	String lastName=obj.getCellData("Data",3,2);
	String password=obj.getCellData("Data",4,2);
	String day=obj.getCellData("Data",5,2);
	String month1=obj.getCellData("Data",6,2);
	String year1=obj.getCellData("Data",7,2);
	String fname=obj.getCellData("Data",8,2);
	String lname=obj.getCellData("Data",9,2);
	String country=obj.getCellData("Data",10,2);
	String location=obj.getCellData("Data",11,2);
	String city=obj.getCellData("Data",12,2);
	String zip=obj.getCellData("Data",13,2);
	String additional=obj.getCellData("Data",14,2);
	String phone=obj.getCellData("Data",15,2);
	String mob_phone=obj.getCellData("Data",16,2);
	String alias=obj.getCellData("Data",17,2);
	String val=obj.getCellData("Data",18,2);
	public void newUserRegister() {
		click(signIn);
		WebElement email= waitElement(driver, emailInput);
		sendDataToInput(email,this.email);
		click(createanAccountBtn);
		clickOnRadioBtn(driver, userTitle);
		sendDataToInput(firstnameInput,firstName);
		sendDataToInput(lastnameInput,lastName);
		sendDataToInput(passInput,password);
		selectFromDropdown(days,day);
		selectFromDropdown(month,month1);
		selectFromDropdown(year,year1);
		sendDataToInput(addressFirstname,fname);
		sendDataToInput(addressLastname,lname);
		sendDataToInput(addressCountry,country);
		sendDataToInput(addressAddress,location);
		sendDataToInput(addressCityInput,city);
		selectFromDropdown(addressStatedd, "5");
		sendDataToInput(addressZipInput,zip);
		selectFromDropdown(addressCountrydd, "21");
		sendDataToInput(addressAddInforTa, additional);
		sendDataToInput(addressPhoneInput,phone);
		sendDataToInput(addressPhoneMobInput,mob_phone);
		sendDataToInput(addressAliasInput,alias);
		click(registerBtn);
		validate(registerSuccess,val);
	}
	
	public void validateEmail() {
		click(signIn);
		WebElement email= waitElement(driver, emailInput);
		sendDataToInput(email,"fdsfdffdsfsdfsfs");
		click(createanAccountBtn);
		validateEmail(driver,emailError,"Invalid email address.");
	}
	
	public void validateMandatoryFields() {
			click(signIn);
			WebElement email= waitElement(driver, emailInput);
			sendDataToInput(email,this.email);
			click(createanAccountBtn);
			clickOnRadioBtn(driver, userTitle);
			sendDataToInput(firstnameInput,firstName);
			sendDataToInput(lastnameInput,lastName);
			sendDataToInput(passInput,password);
			selectFromDropdown(days,day);
			selectFromDropdown(month,month1);
			selectFromDropdown(year,year1);
			sendDataToInput(addressFirstname, "");
			sendDataToInput(addressLastname, "");
			sendDataToInput(addressCountry, "");
			sendDataToInput(addressAddress, "");
			sendDataToInput(addressCityInput, "");
			selectFromDropdown(addressStatedd, "5");
			sendDataToInput(addressZipInput,zip);
			selectFromDropdown(addressCountrydd, "21");
			sendDataToInput(addressAddInforTa, additional);
			sendDataToInput(addressPhoneInput,phone);
			sendDataToInput(addressPhoneMobInput,mob_phone);
			sendDataToInput(addressAliasInput,alias);
			click(registerBtn);
			validateMandatoryFields(driver, mandatoryFielsError);
	}
	
	public void validateFieldsFormat() {
		click(signIn);
		WebElement email= waitElement(driver, emailInput);
		sendDataToInput(email,"singh9157667@gmail.com");
		click(createanAccountBtn);
		clickOnRadioBtn(driver, userTitle);
		sendDataToInput(firstnameInput,"56575757");
		sendDataToInput(lastnameInput, "76876687");
		sendDataToInput(passInput, "chandrakr");
		selectFromDropdown(days, "30");
		selectFromDropdown(month, "12");
		selectFromDropdown(year, "1996");
		sendDataToInput(addressFirstname, "");
		sendDataToInput(addressLastname, "");
		sendDataToInput(addressCountry, "");
		sendDataToInput(addressAddress, "");
		sendDataToInput(addressCityInput, "");
		selectFromDropdown(addressStatedd, "5");
		sendDataToInput(addressZipInput, "90011");
		selectFromDropdown(addressCountrydd, "21");
		sendDataToInput(addressAddInforTa, "15205 North Kierland Blvd. Suite 100");
		sendDataToInput(addressPhoneInput,"5454544554");
		sendDataToInput(addressPhoneMobInput, "4553435343");
		sendDataToInput(addressAliasInput,"Data Completed");
		click(registerBtn);
		validateMandatoryFields(driver, mandatoryFielsError);
}
}
