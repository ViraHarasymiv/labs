package edu.IFNTUNG.bpbonline.application.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import edu.IFNTUNG.bpbonline.utils.StringUtils;

public class CreateAccountPage extends BasePage {

    private By maleRadioButton = By.xpath("//input[@value='m']");
    private By firstNameField = By.xpath("//input[@name='firstname']");
    private By lastNameField = By.xpath("//input[@name='lastname']");
    private By dataPicker = By.xpath("//input[@class='hasDatepicker']");
    private By emailField = By.xpath("//input[@name='email_address']");
    private By companyNameField = By.xpath("//input[@name='company']");
    private By streetAddressField = By.xpath("//input[@name='street_address']");
    private By postCodeField = By.xpath("//input[@name='postcode']");
    private By cityField = By.xpath("//input[@name='city']");
    private By stateField = By.xpath("//input[@name='state']");
    private By selectCountryMenu = By.xpath("//select[@name='country']");
    private By telephoneNumberField = By.xpath("//input[@name='telephone']");
    private By newsletterCheckbox = By.xpath("//input[@name='newsletter']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By passwordConfirmationField = By.xpath("//input[@name='confirmation']");
    private By submitButton = By.xpath("//span[contains(text(), 'Continue')]");

    public CreateAccountPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Click on the Male radio button
     */
    public CreateAccountPage clickOnMaleRadioButton() {
        log.info("Click on the Male radio button");
        click(maleRadioButton);
        return this;
    }

    /**
     * Type the user's First and Last Name
     */
    public CreateAccountPage enterUserFirstAndLastName(String firstUserName, String lastName) {
        log.info("enter the user's First and Last Name");
        type(firstUserName, firstNameField);
        type(lastName, lastNameField);
        return this;
    }

    /**
     * Type the user's birthday
     */
    public CreateAccountPage enterUserBirthDay(String birthDay) {
        selectDate(birthDay, dataPicker);
        return this;
    }

    /**
     * Type the user's email
     */
    public CreateAccountPage enterUserEmail(String fix_length) {
        String email = StringUtils.generateRandomEmail(Integer.parseInt(fix_length));
        type(email, emailField);
        return this;
    }

    /**
     * Submit entered user's information with valid data
     */
    public AccountSuccessPage submitEnteredInformationWithValidDate() {
        click(submitButton);
        return new AccountSuccessPage(driver, log);
    }

    /**
     * Type the user's company
     */
    public CreateAccountPage enterCompanyName(String company) {
        type(company, companyNameField);
        return this;
    }

    /**
     * Type the user's street address and the post code
     */
    public CreateAccountPage enterStreetAddressAndPostCode(String streetAddress, String postCode) {
        type(streetAddress, streetAddressField);
        type(postCode, postCodeField);
        return this;
    }

    /**
     * Type the user's city and state
     */
    public CreateAccountPage enterUserCityAndState(String city, String state) {
        type(city, cityField);
        type(state, stateField);
        return this;
    }

    /**
     * Select the user's country
     */
    public CreateAccountPage selectCountry(String country) {
        Select select = new Select(find(selectCountryMenu));
        select.selectByVisibleText(country);
        return this;
    }

    /**
     * Type the user's telephone number
     */
    public CreateAccountPage enterTelephoneNumber(String telephoneNumber) {
        type(telephoneNumber, telephoneNumberField);
        return this;
    }

    /**
     * Check the News Letter checkbox
     */
    public CreateAccountPage checkNewsLetterCheckBox() {
        click(newsletterCheckbox);
        return this;
    }

    /**
     * Create and confirm new password
     */
    public CreateAccountPage createPassword(String password) {
        type(password, passwordField);
        type(password, passwordConfirmationField);
        return this;
    }

    /**
     * Submit entered user's information with invalid data
     */
    public CreateAccountPage submitEnteredInformationWithInValidDate() {
        click(submitButton);
        return this;
    }

    /**
     * Switch to alert and get it's message
     */
    public String getAlertText() {
        Alert alert = switchToAlert();
        String alertText = alert.getText();
        log.info("Alert says: " + alertText);
        return alertText;
    }
}
