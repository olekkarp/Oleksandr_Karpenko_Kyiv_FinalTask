package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyBagPage extends BasePage{

    @FindBy(xpath = "//li[@class='bag-item-holder']")
    private WebElement productIconInMyBag;

    @FindBy(xpath = "//button[@class='bag-item-remove']")
    private WebElement removeProductButton;

    @FindBy(xpath = "//h2[@class='empty-bag-title']")
    private WebElement bagContents;

    public MyBagPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromBagContents(){return bagContents.getText();}

    public WebElement getBagContents(){return bagContents;}

    public void clickOnRemoveProductButton(){removeProductButton.click();}

    public boolean isProductIconInMyBagVisible(){return productIconInMyBag.isDisplayed();}

    public WebElement getProductIconInMyBag(){return productIconInMyBag;}
}
