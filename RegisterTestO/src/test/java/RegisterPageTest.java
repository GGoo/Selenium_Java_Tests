import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegisterPageTest {

  
    private WebDriver driver;

   
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
    public void canOpenRegisterPage() {
       
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        Assert.assertTrue( registerPage.isAt() );
    }

    @Test
    public void canRegisterNewIndividualUser() {
        
        RegisterPage registerPage = new RegisterPage(driver);
        ConfirmedPage confirmedPage = new ConfirmedPage(driver);
        User user = new User();
        registerPage.open();
        registerPage.registerNewIndividualUser(user);
        Assert.assertTrue( confirmedPage.isAt() );
        Assert.assertEquals(
                user.getFirstName(),
                confirmedPage.getLoggedUserName()
        );
    }
}
