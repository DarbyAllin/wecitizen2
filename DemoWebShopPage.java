package testpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.NoSuchElementException;

public class DemoWebShopPage {

        @FindBy(xpath = "//a")
        private List<WebElement> demoWebShopPageLinks;

        public DemoWebShopPage(WebDriver driver){
            PageFactory.initElements(driver,this);
        }

        public void clickOnLink(String linkText){
            for(WebElement pageLink:demoWebShopPageLinks){
                if(pageLink.getText().equalsIgnoreCase(linkText)){
                    pageLink.click();
                    return;
                }
            }
            throw new NoSuchElementException("The Link " + linkText + "not found on the page");
        }
    }
