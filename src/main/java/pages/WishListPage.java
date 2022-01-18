package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage {

    @FindBy(xpath = "//section[@class='productTilesWrapper_15Cf0']")
    private WebElement productSection;

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductSectionVisible(){return productSection.isDisplayed();}

    public WebElement getProductSection(){return productSection;}
}
