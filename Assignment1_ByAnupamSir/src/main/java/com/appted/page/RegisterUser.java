package com.appted.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appted.actions.ActionsOnWebElements;
import com.appted.data.GetData;

public class RegisterUser extends ActionsOnWebElements{
	WebDriver driver;
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
	
	public void newUserRegister() {
		click(signIn);
		WebElement email= waitElement(driver, emailInput);
		sendDataToInput(email,GetData.getDataFromExcel("NewUser",1, 0));
		click(createanAccountBtn);
		clickOnRadioBtn(driver, userTitle);
		sendDataToInput(firstnameInput,GetData.getDataFromExcel("NewUser",1, 1));
		sendDataToInput(lastnameInput, GetData.getDataFromExcel("NewUser",1, 2));
		sendDataToInput(passInput,GetData.getDataFromExcel("NewUser",1, 3));
		selectFromDropdown(days, GetData.getDataFromExcel("NewUser",1, 4));
		selectFromDropdown(month, GetData.getDataFromExcel("NewUser",1, 5));
		selectFromDropdown(year, GetData.getDataFromExcel("NewUser",1, 6));
		sendDataToInput(addressFirstname, GetData.getDataFromExcel("NewUser",1, 7));
		sendDataToInput(addressLastname, GetData.getDataFromExcel("NewUser",1, 8));
		sendDataToInput(addressCountry, GetData.getDataFromExcel("NewUser",1, 9));
		sendDataToInput(addressAddress,GetData.getDataFromExcel("NewUser",1, 10));
		sendDataToInput(addressCityInput,GetData.getDataFromExcel("NewUser",1, 11));
		selectFromDropdown(addressStatedd, "5");
		sendDataToInput(addressZipInput,GetData.getDataFromExcel("NewUser",1, 12));
		selectFromDropdown(addressCountrydd, "21");
		sendDataToInput(addressAddInforTa, GetData.getDataFromExcel("NewUser",1, 13));
		sendDataToInput(addressPhoneInput,GetData.getDataFromExcel("NewUser",1, 14));
		sendDataToInput(addressPhoneMobInput, GetData.getDataFromExcel("NewUser",1, 15));
		sendDataToInput(addressAliasInput,GetData.getDataFromExcel("NewUser",1, 16));
		click(registerBtn);
		validate(registerSuccess,GetData.getDataFromExcel("NewUser",1, 22));
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
			sendDataToInput(email,"singh9157667@gmail.com");
			click(createanAccountBtn);
			clickOnRadioBtn(driver, userTitle);
			sendDataToInput(firstnameInput,"Chandra");
			sendDataToInput(lastnameInput, "Prakash");
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
