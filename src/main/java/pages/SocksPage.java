package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SocksPage extends BasePage{

    @FindBy(xpath = "//div[@class='_3-pwX1m']")
    private WebElement socksProducts;

    @FindBy(xpath = "//button//div[text()='Size']")
    private WebElement sizeButton;

    @FindBy(xpath = "//ul[@class='C_vX7H2 dV6RFzr']")
    private WebElement sizeVariations;

    @FindBy(xpath = "//div[text()='No Size']")
    private WebElement noSizeButton;

    @FindBy(xpath = "//article[@id='product-24140772']")
    private WebElement socksIcon;

    public SocksPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSocksProduct(){socksIcon.click();}

    public void clickOnNoSizeButton(){
        sizeButton.click();
        waitVisibilityOfElement(60, getSizeVariations());
        noSizeButton.click();
        sizeButton.click();
    }

    public WebElement getSizeVariations(){return sizeVariations;}

    public boolean isSocksProductsVisible(){return socksProducts.isDisplayed();}

    public WebElement getSocksProducts(){return socksProducts;}
}
