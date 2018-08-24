import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Generate {

        public String email() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://generator.email/");
        driver.findElement(By.linkText("Generate new e-mail")).click();
        String emailText = driver.findElement(By.id("email_ch_text")).getText();
        driver.quit();
        return emailText;
    }
}
