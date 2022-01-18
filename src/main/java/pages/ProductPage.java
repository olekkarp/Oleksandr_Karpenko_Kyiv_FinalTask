package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.awt.image.Kernel;

public class ProductPage extends BasePage {

    private static final long DEFAULT_TIMEOUT = 90;

    @FindBy(xpath = "//div[@class='gallery-images']")
    private WebElement imageProduct;

    @FindBy(xpath = "//span[text()='Add to bag']")
    private WebElement addToBagButton;

    @FindBy(xpath = "//select[@aria-label='Please select']")
    private WebElement selectSizeButton;

    @FindBy(xpath = "//span[@type='bagFilled']")
    private WebElement bagFilled;

    @FindBy(xpath = "//div[@class='_2g_Mcyd']/dd")
    private WebElement textInMyBag;

    @FindBy(xpath = "//span[@id='selectSizeError']")
    private WebElement selectSizeErrorMessage;

    @FindBy(xpath = "//div[@id='minibag-dropdown']")
    private WebElement myBagDropDown;

    @FindBy(xpath = "//a[@data-test-id='bag-link']")
    private WebElement viewBagButton;

    @FindBy(xpath = "//button[@data-test-id='deliveryAndReturns__shippingRestrictionsButton']")
    private WebElement shippingRestrictionsButton;

    @FindBy(xpath = "//div[@class='_3V9sS']")
    private WebElement shippingRestrictionsIcon;

    @FindBy(xpath = "//input[@id='shippable-countries-input']")
    private WebElement shippableCountriesSearch;

    @FindBy(xpath = "//p[@class='_2n65t']")
    private WebElement errorSearchCountryMassage;


    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public boolean isErrorSearchCountryMassageVisible(){return errorSearchCountryMassage.isDisplayed();}

    public WebElement getErrorSearchCountryMassage(){return errorSearchCountryMassage;}

    public void enterShippableCountriesSearch(final String country){
        shippableCountriesSearch.click();
        shippableCountriesSearch.sendKeys(country);
    }

    public boolean isShippingRestrictionsIconVisible(){return shippingRestrictionsIcon.isDisplayed();}

    public WebElement getShippingRestrictionsIcon(){return shippingRestrictionsIcon;}

    public void clickOnShippingRestrictions(){shippingRestrictionsButton.click();}

    public void clickOnViewBagButton(){viewBagButton.click();}

    public void clickMyBagDropDown(){
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//button[@data-testid='miniBagIcon']"));
        builder.moveToElement(element).build().perform();
        waitForPageLoadComplete(DEFAULT_TIMEOUT);
        waitForAjaxToComplete(DEFAULT_TIMEOUT);
        waitVisibilityOfElement(DEFAULT_TIMEOUT, getMyBagIcon());
        waitVisibilityOfElement(DEFAULT_TIMEOUT, getViewBagButton());
    }

    public WebElement getViewBagButton(){return viewBagButton;}

    public boolean isErrorMessageVisible(){return selectSizeErrorMessage.isDisplayed();}

    public WebElement getMyBagIcon(){return myBagDropDown;}

    public String getTextInMyBag(){return textInMyBag.getText();}

    public void clickOnBagFilled(){bagFilled.click();}

    public void clickOnSelectFortyTwoSize(){selectSizeButton.click();}

    public void clickOnAddToBag(){addToBagButton.click();}

    public void clickOnSelectSizeButton(){
        selectSizeButton.click();
    }

    public boolean isImageProductVisible(){return imageProduct.isDisplayed();}

    public WebElement getImageProduct() {return imageProduct;}


}
