import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


import java.io.IOException;

public class DomqaWebTest {

    private WebDriver driver;
    //private Screenshot screenshot =new Screenshot();

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @After
    public void tearDown(){
        driver.quit();
        driver = null;

    }

    @Test
    public void canOpenDomqaPage() throws IOException {
        Page page = new Page(driver);
        page.open();
        page.isAt();

    }

    @Test
    public void canRegisterNewUser() throws IOException {
        Page page = new Page(driver);
        page.registration();
    }


    @Test
    public void DragInteraction() throws IOException {
        Draggable draggable = new Draggable(driver);
        draggable.openDraggable();
    }

}
//musze dorobic screnshota ze robi i fakowego maila co chwila nowego i moze jak sie da user