package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    private WebElement errorEmailMessage;

    @FindBy(xpath = "//input[@name='Username']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='info info-centre   ']")
    private WebElement signInWith;

    @FindBy(xpath = "//div[@class='signin-options']")
    private WebElement signInOptions;

    @FindBy(xpath = "//div[@class='form form-login']")
    private WebElement signInForm;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getErrorMessage(){return errorEmailMessage;}

    public WebElement getSignInForm(){return signInForm;}

    public boolean isSignInFormVisible(){return signInForm.isDisplayed();}

    public boolean isSignInOptionsVisible(){return signInOptions.isDisplayed();}

    public boolean isSignInWithVisible(){return signInWith.isDisplayed();}

    public void clickOnSignInButton(){signInButton.click();}

    public void enterPassword(final String password){
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void enterEmail(final String email){
        emailField.click();
        emailField.sendKeys(email);
    }

    public boolean isErrorMessageVisible(){
         return  errorEmailMessage.isDisplayed();
    }
}
