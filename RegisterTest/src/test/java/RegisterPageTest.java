import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class RegisterPageTest {

    private WebDriver driver;
    private Screenshot screenshot = new Screenshot();

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void canOpenRegisterPage() throws IOException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();

        screenshot.take(driver, "canOpenRegisterPage.png");

        Assert.assertTrue(registerPage.isAt());
    }

    @Test
    public void canRegisterNewIndividualUser() throws IOException {
        RegisterPage registerPage = new RegisterPage(driver);
        ConfirmedPage confirmedPage = new ConfirmedPage(driver);
        User user = new User();

        registerPage.open();
        registerPage.registerNewIndividualUser(user);

        screenshot.take(driver, "canRegisterNewIndividualUser.png");


        Assert.assertTrue(confirmedPage.isAt());
        Assert.assertEquals(user.getFirstName(),
                confirmedPage.getLoggedUserName());
    }

    @Test
    public void canRegisterCorporateUSer() {
        RegisterPage registerPage = new RegisterPage(driver);
        ConfirmedPage confirmedPage = new ConfirmedPage(driver);

        registerPage.open();
        registerPage.registerNewCompanyUser();
        String url = "a";
        Assert.assertTrue(confirmedPage.isAt());
        Assert.assertEquals("Jan",
                confirmedPage.getLoggedUserName());
    }
}
