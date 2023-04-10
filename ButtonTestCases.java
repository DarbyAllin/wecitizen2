package buttontestcases;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ButtonTestCases {
    WebDriver driver;
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://artoftesting.com/samplesiteforselenium");
    }

    @Test
    public void verifyButtonIsPresent(){
        WebElement button =driver.findElement(By.cssSelector("button#idOfButton"));
        if(button != null){
            System.out.println("button is present");
        }
        else{
            System.out.println("button is not present");
        }
    }

    @Test
    public void verifyButtonColor(){
        WebElement button =driver.findElement(By.cssSelector("button#idOfButton"));
       String buttonBackgroundColor = button.getCssValue("background-color");
        Assert.assertTrue(buttonBackgroundColor.equals("#2f4468"),"Colors do not match");
    }

    @Test
    public void verifyButtonEnabled(){
        WebElement button =driver.findElement(By.cssSelector("button#idOfButton"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if(button.isEnabled()){
            js.executeScript("arguments[0].scrollIntoView()", button);
            button.click();
        }
        Assert.assertTrue(button.isEnabled());
    }

    @Test
    public void verifyButtonColorChangeAfterHover(){
        WebElement button =driver.findElement(By.cssSelector("button#idOfButton"));
        String beforeHoverColor= button.getCssValue("color");
        Actions action = new Actions(driver);
        action.moveToElement(button).perform();
        String afterHoverColor = button.getCssValue("color");
        Assert.assertEquals(beforeHoverColor, afterHoverColor);
    }

    @Test
    public void verifyHoverMessageOnButton(){
        WebElement button =driver.findElement(By.cssSelector("button#idOfButton"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", button);
        Actions action = new Actions(driver);
        action.moveToElement(button).perform();
        String actualHoverMessage = button.getAttribute("title");
        String expectedHoverMessage = "Hovering over me!!";
        Assert.assertEquals(actualHoverMessage, expectedHoverMessage);
    }
}
