package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    private static final long DEFAULT_TIMEOUT = 90;

    @FindBy(xpath = "//a[text()='Help']")
    private WebElement helpAndContacts;

    @FindBy(xpath = "//div[@id='chrome-header']")
    private WebElement header;

    @FindBy(xpath = "//main[@id='chrome-app-container']")
    private WebElement mainContent;

    @FindBy(xpath = "//div[@id='chrome-footer']")
    private WebElement footer;

    @FindBy(xpath = "//a[@data-testid='miniBagIcon']")
    private WebElement shoppingCart;

    @FindBy(xpath = "//button[@aria-label='My Account']")
    private WebElement myAccount;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement inputField;

    @FindBy(xpath = "//button[@data-testid='search-button-inline']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='_8EFahPg']")
    private WebElement mainContainerOfCategory;

    @FindBy(xpath = "//a[@data-testid='asoslogo']")
    private WebElement asosLogo;

    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']")
    private WebElement savedProduct;

    @FindBy(xpath = "//a[@data-testid='myaccount-link']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//div[@id='e87ba617-daa1-4b64-8f36-ab92e61283f7']//a[text()='Socks']")
    private WebElement socksInClothingCategory;

    @FindBy(xpath = "//a[contains(@href,'|shoes|shop+by+brand|adidas')]")
    private WebElement shopAdidasShoesButton;

    public HomePage(WebDriver driver) {super(driver);}

    public WebElement getSocksInClothingCategory(){return socksInClothingCategory;}

    public void clickAdidasByShoesCategory(){
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//button[@data-id='87a52035-f6fa-401f-bd58-0d259e403cbb']"));
        builder.moveToElement(element).build().perform();
        waitForPageLoadComplete(DEFAULT_TIMEOUT);
        waitForAjaxToComplete(DEFAULT_TIMEOUT);
        waitVisibilityOfElement(DEFAULT_TIMEOUT, getShopAdidasShoesButton());
        shopAdidasShoesButton.click();
    }

    public WebElement getShopAdidasShoesButton(){return shopAdidasShoesButton;}

    public void clickSocksInClothingCategory(){
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//button[@data-id='e87ba617-daa1-4b64-8f36-ab92e61283f7']"));
        builder.moveToElement(element).build().perform();
        waitForPageLoadComplete(DEFAULT_TIMEOUT);
        waitForAjaxToComplete(DEFAULT_TIMEOUT);
        waitVisibilityOfElement(DEFAULT_TIMEOUT, getSocksInClothingCategory());
        socksInClothingCategory.click();
    }

    public void clickOnMyAccount(){
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//button[@aria-label='My Account']"));
        builder.moveToElement(element).build().perform();
        waitForPageLoadComplete(DEFAULT_TIMEOUT);
        waitForAjaxToComplete(DEFAULT_TIMEOUT);
        waitVisibilityOfElement(DEFAULT_TIMEOUT, getSignInLink());
        myAccountLink.click();
    }

    public WebElement getSignInLink(){return myAccountLink;}

    public boolean isHelpAndContactsVisible(){return helpAndContacts.isDisplayed();}

    public void clickOnHelpButton(){ helpAndContacts.click();}

    public boolean isAsosLogoVisible(){return asosLogo.isDisplayed();}

    public boolean isMainContainerOfCategoryVisible(){return mainContainerOfCategory.isDisplayed();}

    public boolean isSearchButtonVisible(){return searchButton.isDisplayed();}

    public void clickOnSearchButton(){searchButton.click();}

    public void searchByKeyword(final String searchText){
        inputField.click();
        inputField.sendKeys(searchText);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public boolean isInputFieldVisible(){return inputField.isDisplayed();}

    public boolean isMyAccountIconVisible(){return myAccount.isDisplayed();}

    public boolean isShoppingCartVisible(){return shoppingCart.isDisplayed();}

    public boolean isFooterVisible(){return footer.isDisplayed();}

    public boolean isMainContentVisible(){return mainContent.isDisplayed();}

    public boolean isHeaderVisible(){return header.isDisplayed();}
}
