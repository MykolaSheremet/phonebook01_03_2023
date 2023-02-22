package ui.page.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddContactWindow {
    WebDriver driver;

    public AddContactWindow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='form-name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='form-lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='form-about']")
    private WebElement aboutInput;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;

    public void fillData(String firstname, String lastname, String about) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstname);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastname);
        aboutInput.clear();
        aboutInput.sendKeys(about);
        saveButton.click();
    }
}
