import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private String url = "https://wro-tem-s-01.codersguru.pl/register/";
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public boolean isAt() {
        return driver.getCurrentUrl().equals(url);
    }

    public void registerNewIndividualUser(User user) {
        Generate generate = new Generate();
        driver.findElement(By.id("fos_user_registration_form_email")).sendKeys(user.getEmail());
        driver.findElement(By.id("fos_user_registration_form_name")).sendKeys(user.getFirstName());
        driver.findElement(By.id("fos_user_registration_form_lastname")).sendKeys(user.getLastName());
        driver.findElement(By.id("fos_user_registration_form_plainPassword_first")).sendKeys(user.getPassword());
        driver.findElement(By.id("fos_user_registration_form_plainPassword_second")).sendKeys(user.getPassword());
        driver.findElement(By.id("form_city")).sendKeys(user.getCity());
        driver.findElement(By.id("form_postal_code")).sendKeys(user.getPostalCode());
        driver.findElement(By.id("form_street")).sendKeys(user.getStreet());
        driver.findElement(By.id("form_number")).sendKeys(user.getHouseNumber());

        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        driver.findElement(By.id("register-submit-btn")).click();
    }

    public void registerNewCompanyUser() {
        Generate generate = new Generate();
        driver.findElement(By.id("company")).click();
        driver.findElement(By.id("fos_user_registration_form_email")).sendKeys(generate.email());
        driver.findElement(By.id("fos_user_registration_form_name")).sendKeys("John");
        driver.findElement(By.id("fos_user_registration_form_lastname")).sendKeys("Nowak");
        driver.findElement(By.id("fos_user_registration_form_plainPassword_first")).sendKeys("kekede");
        driver.findElement(By.id("fos_user_registration_form_plainPassword_second")).sendKeys("kekede");
        driver.findElement(By.id("form_city")).sendKeys("Paris");
        driver.findElement(By.id("form_postal_code")).sendKeys("52-198");
        driver.findElement(By.id("form_street")).sendKeys("Zanglijsterlaan");
        driver.findElement(By.id("form_number")).sendKeys("2");
        driver.findElement(By.id("fos_user_registration_form_company_name")).sendKeys("Best");
        driver.findElement(By.id("fos_user_registration_form_nip")).sendKeys(generate.nip());

        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        driver.findElement(By.id("register-submit-btn")).click();
    }
}
