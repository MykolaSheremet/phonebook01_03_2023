package ui.tests.contact;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.page.MenuEl;
import ui.page.contact.AddContactWindow;
import ui.page.contact.ContactPage;
import ui.page.login.LoginPage;
import ui.tests.TestBase;

import java.util.Map;

public class AddNewContactTest extends TestBase {
    Faker faker = new Faker();
    MenuEl menu;
    AddContactWindow addContactWindow;
    ContactPage contactPage;
    LoginPage loginPage;
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String about = faker.lorem().sentence(4);

    @BeforeMethod
    public void precondition() {
        loginPage = new LoginPage(driver);
        loginPage.getLogin(EMAIL, PASSWORD);
    }

    @Test
    public void addNewContactTest() {
        menu = new MenuEl(driver);
        menu.clickAddNewContactButton();
        addContactWindow = new AddContactWindow(driver);
        addContactWindow.fillData(firstName, lastName, about);
        contactPage = new ContactPage(driver);

//        Assert.assertEquals(contactPage.getFirstNameField(), firstName);
//        Assert.assertEquals(contactPage.getLastNameField(), lastName);
//        Assert.assertEquals(contactPage.getAboutField(), about);

        Map<String, String> info = contactPage.getInfo();

        Assert.assertEquals(info.get("first name"), firstName);
        Assert.assertEquals(info.get("last name"), lastName);
        Assert.assertEquals(info.get("contact description"), about);
    }
}
