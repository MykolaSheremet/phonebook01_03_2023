package ui.tests.login;

import org.testng.annotations.Test;
import ui.page.login.LoginPage;
import ui.tests.TestBase;

public class LoginTest extends TestBase {

    String email = "test@gmail.com";
    String password = "test@gmail.com";

    LoginPage loginPage;

    @Test
    public void LoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.getLogin(email, password);
    }
}
