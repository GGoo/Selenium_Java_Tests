import org.openqa.selenium.WebDriver;

public class Draggable {

    private String urlDraggable = "http://demoqa.com/draggable/";
    private WebDriver driver;

    public Draggable(WebDriver driver) {
        this.driver = driver;
    }

    public void openDraggable() {
        driver.get(urlDraggable);
    }

}
