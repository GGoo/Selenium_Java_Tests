import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Page {

    private String url = "http://demoqa.com";
    private WebDriver driver;


    public Page(WebDriver driver) {
        this.driver = driver;
    }


    public void open() {
        driver.get(url);
    }

    public boolean isAt() {
        return driver.getCurrentUrl().equals(url);
    }



    public void registration (){

        driver.get(url);
        driver.findElement(By.id("menu-item-374")).click();
        driver.findElement(By.name("first_name")).sendKeys("First Name");
        driver.findElement(By.id("name_3_lastname")).sendKeys("Last Name");
        driver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[2]/div/div/input[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[3]/div/div/input[2]")).click();

        Select droplistCountry = new Select (driver.findElement(By.xpath("//*[@id=\"dropdown_7\"]")));
        droplistCountry.selectByVisibleText("Netherlands");
        Select dropListMonth = new Select(driver.findElement(By.id("mm_date_8")));
        dropListMonth.selectByVisibleText("10");
        Select dropListDay = new Select(driver.findElement(By.id ("dd_date_8")));
        dropListDay.selectByVisibleText("31");
        Select dropListYear = new Select (driver.findElement(By.id("yy_date_8")));
        dropListYear.selectByVisibleText("2009");


        driver.findElement(By.id("phone_9")).sendKeys("31618932567");
        driver.findElement(By.id("username")).sendKeys("usernamedummy");
        driver.findElement(By.id("email_1")).sendKeys("generateemail@email.com");
        driver.findElement(By.id("password_2")).sendKeys("generatepass102938!!!xyzq");
        driver.findElement(By.id("confirm_password_password_2")).sendKeys("generatepass102938!!!xyzq");
        driver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[14]/div/input")).click();


    }


}
