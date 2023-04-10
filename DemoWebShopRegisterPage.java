package testpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoWebShopRegisterPage {

    @FindBy(css = "input#gender-male")
    private WebElement maleRadioButton;

    @FindBy(css = "input#gender-female")
    private WebElement femaleRadioButton;

    @FindBy(css = "input#FirstName")
    private WebElement firstName;

    @FindBy(css = "input#LastName")
    private WebElement lastName;

    @FindBy(css = "input#Email")
    private WebElement email;

    @FindBy(css = "input#Password")
    private WebElement password;

    @FindBy(css = "input#ConfirmPassword")
    private WebElement confirmPassword;

    @FindBy(css = "input#register-button")
    private WebElement registerButton;

    @FindBy(xpath = "//a[contains(text(),'shantanughanekar72@gmail.com')]")
    private WebElement emailLink;

    public DemoWebShopRegisterPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void clickOnGenderMaleRadioButton(){
        maleRadioButton.click();
    }

    public void clickOnGenderFemaleRadioButton(){
        femaleRadioButton.click();
    }

    public void enterFirstName(String firstname) {
        firstName.sendKeys(firstname);
    }

    public void enterLastName(String lastName){
        this.lastName.sendKeys(lastName);
    }

    public void enterEmailAddress(String email){
        this.email.sendKeys(email);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword.sendKeys(confirmPassword);
    }

    public void clickRegisterButton(){
        registerButton.click();
    }

    public boolean verifyEmailAddress(String emailAddress) {
        if (emailLink.getText().equals(emailAddress))
            return true;
        else
            return false;
    }
}
