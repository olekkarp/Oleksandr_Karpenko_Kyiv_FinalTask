package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HelpAndContactPage extends BasePage{

    @FindBy(xpath = "//div[@class='Hero_heroContainer Hero_heroHomepage  ']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@placeholder='Search for help']")
    private WebElement searchInput;

    @FindBy(xpath = "//li[@aria-setsize='12']//div[@class='CardListItem_textWrapper']")
    private List<WebElement> tittleTextList;

    @FindBy(xpath = "//div[@aria-relevant='additions text']")
    private WebElement searchLists;

    public HelpAndContactPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchListsVisible(){return searchLists.isDisplayed();}

    public List<WebElement> getTitleTextList(){return tittleTextList;}

    public void enterQuestion(final String question){
        searchInput.click();
        searchInput.sendKeys(question);
        searchInput.sendKeys(Keys.ENTER);
    }

    public WebElement getSearchLists(){return searchLists;}

    public WebElement getSearchField(){return searchField;}

    public boolean isSearchFieldVisible(){return searchField.isDisplayed();}
}
