import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmedPage {

    private String url = "https://wro-tem-s-01.codersguru.pl/register/confirmed";
    private WebDriver driver;
    
    public ConfirmedPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAt() {
        return driver.getCurrentUrl().equals(url);
    }

    public String getLoggedUserName() {
        return driver.findElement(By.id("user-name")).getText();
    }
}
