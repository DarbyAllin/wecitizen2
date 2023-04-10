package testpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoWebShopLoginPage {

    public DemoWebShopLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input#Email")
    private WebElement email;

    @FindBy(css = "input#Password")
    private WebElement password;

    @FindBy(xpath = "(//input[contains(@class,'button-1')])[last()]")
    private WebElement logInButton;

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    private WebElement logOutLink;

    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    private WebElement logInLink;

    public void enterEmail(String email){
        this.email.sendKeys(email);
    }

    public void enterPassword(String password){
        this.password.sendKeys(password);
    }

    public void logIn(){
        logInButton.click();
    }

    public boolean verifyLogOut(String text){
        if(logInLink.getText().equalsIgnoreCase(text))
            return true;
        else
            return false;
    }
    public void logOut(){
        logOutLink.click();
    }

}
