package demowebshop;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.*;
import testpages.DemoWebShopLoginPage;
import testpages.DemoWebShopPage;
import testpages.DemoWebShopRegisterPage;

public class TestEmailAndLogOut {
    WebDriver driver;
    DemoWebShopPage demo;
    DemoWebShopRegisterPage demoWeb;
    DemoWebShopLoginPage demoLogin;
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        demo = new DemoWebShopPage(driver);
        demoWeb = new DemoWebShopRegisterPage(driver);
        demoLogin = new DemoWebShopLoginPage(driver);
    }

    @Test
    public void testLoginEmail() throws InterruptedException {
        demo.clickOnLink("Log in");
        demoLogin.enterEmail("shantanughanekar72@gmail.com");
        demoLogin.enterPassword("shantanu12#");
        demoLogin.logIn();
        boolean verifyEmailAddress = demoWeb.verifyEmailAddress("shantanughanekar72@gmail.com");
        assertTrue(verifyEmailAddress,"email's do not match according to the requirement");
        demoLogin.logOut();
    }

    @Test
    public void testLogOut() throws InterruptedException {
        demo.clickOnLink("Log in");
        demoLogin.enterEmail("shantanughanekar72@gmail.com");
        demoLogin.enterPassword("shantanu12#");
        demoLogin.logIn();
        demoLogin.logOut();
        boolean verifyLogout = demoLogin.verifyLogOut("Log in");
        assertTrue(verifyLogout,"Log out failed");
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
