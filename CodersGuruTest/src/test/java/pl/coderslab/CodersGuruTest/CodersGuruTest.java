package pl.coderslab.CodersGuruTest;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By.*;

public class CodersGuruTest {

	private WebDriver driver;
	private String baseUrl = "https://wro-tem-s-01.codersguru.pl/";
	private String howItWorksUrl = "https://wro-tem-s-01.codersguru.pl/#how-it-works";
	private String pricesUrl = "https://wro-tem-s-01.codersguru.pl/cennik";
	private String mentorUrl = "https://docs.google.com/forms/";
	private String registerUrl = "https://wro-tem-s-01.codersguru.pl/register/";
	private String loginUrl = "https://wro-tem-s-01.codersguru.pl/login";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}


	@Test
	public void testHowItWorks() throws Exception {
		driver.findElement(By.linkText("Jak to działa")).click();
		if (howItWorksUrl.equals(driver.getCurrentUrl())) {
			System.out.println("how it works poprawnie");
		} else
			System.out.println("how it works niepoprawnie");
		Assert.assertEquals(
				"URL didn't match *\"Jak to działa*\"",
				howItWorksUrl,
				driver.getCurrentUrl()
				);
	}

	@Test
	public void testPrices() throws Exception {
		driver.findElement(By.linkText("Cennik")).click();
		if (pricesUrl.equals(driver.getCurrentUrl())) {
			System.out.println("prices poprawnie");
		} else
			System.out.println("prices niepoprawnie");
		Assert.assertEquals(pricesUrl, driver.getCurrentUrl());
		WebElement header = driver.findElement(By.tagName("h1"));
		if (header.getText().equals("Cennik")) {
			System.out.println("header poprawnie");
		} else
			System.out.println("header niepoprawnie");
		Assert.assertEquals("Cennik", header.getText());
	}

	@Test
	public void testMentor() throws Exception {
		driver.findElement(By.linkText("Zostań Mentorem")).click();
		
		Assert.assertTrue(
				"URL didn't start with \"https://docs.google.com/forms/\"",
				driver.getCurrentUrl().startsWith(mentorUrl)
				);
	}

	@Test
	public void testRegister() throws Exception {
		driver.findElement(By.cssSelector("body > section.main-page-top > div > form > input.link.main-page-top__email-input-sent")).click();
		
		Assert.assertEquals(
				"URL didn't match *\"Załóż konto*\"",
				registerUrl,
				driver.getCurrentUrl()
				);
	}

	@Test
	public void testLogin() throws Exception {
		driver.findElement(By.cssSelector("button.header__button")).click();
		Assert.assertTrue("Page login didnt show up",
				driver.getCurrentUrl().endsWith("/login"));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
