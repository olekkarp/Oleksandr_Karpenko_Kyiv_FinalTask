package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.security.auth.x500.X500Principal;
import java.util.List;

public class SearchResultPage extends BasePage{

    @FindBy(xpath = "//article[@id='product-200502330']")
    private WebElement textNewBalanceTitle;

    @FindBy(xpath = "//article[@id='product-200502330']")
    private WebElement firstNbProductIcon;

    @FindBy(xpath = "//button//div[text()='Colour']")
    private WebElement colourFilter;

    @FindBy(xpath = "//article[@id='product-12591346']")
    private WebElement greyHoodie;

    @FindBy(xpath = "//div[@class='_3J74XsK']")
    private List<WebElement> titleTextProductsList;

    @FindBy(xpath = "//div[@aria-label='Filters']")
    private WebElement filters;

    @FindBy(xpath = "//div[@style='background-color: rgb(190, 190, 190);']")
    private WebElement greyColour;

    @FindBy(xpath = "//article[@id='product-200858321']")
    private WebElement productHoodie;

    @FindBy(xpath = "//ul[@class='C_vX7H2 dV6RFzr']")
    private WebElement colourFilterList;

    @FindBy(xpath = "//article[@id='product-12591346']//span[@class='_30BqGyh']")
    private WebElement addGreyHoodieToWishList;

    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']")
    private WebElement wishListButton;

    @FindBy(xpath = "//h1[@class='_1hVpqlz']")
    private WebElement headingAdidas;


    public SearchResultPage(WebDriver driver) {super(driver);}


    public boolean isHeadingAdidasVisible(){return headingAdidas.isDisplayed();}

    public WebElement getHeadingAdidas(){return headingAdidas;}

    public void clickOnWishListButton(){wishListButton.click();}

    public void clickOnAddGreyHoodieWishlist(){addGreyHoodieToWishList.click();}

    public WebElement getColourFilterList(){return colourFilterList;}

    public boolean isProductHoodieVisible(){return  productHoodie.isDisplayed();}

    public WebElement getFilters(){return filters;}

    public void clickOnGreyColour(){greyColour.click();}

    public void clickOnFirstProductIcon(){
        firstNbProductIcon.click();
    }

    public List<WebElement> getTextProductsList(){return titleTextProductsList;}

    public void clickOnColourFilter(){colourFilter.click();}

    public boolean isFiltersVisible(){return filters.isDisplayed();}

    public WebElement getGreyHoodie(){return greyHoodie;}

    public boolean isGreyProductVisible(){return greyHoodie.isDisplayed();}

    public boolean isFirstProductVisible(){return firstNbProductIcon.isDisplayed();}

    public WebElement getFirstProductIcon(){return firstNbProductIcon;}

    public String getTextFromFirstTitle(){return textNewBalanceTitle.getText();}
}
