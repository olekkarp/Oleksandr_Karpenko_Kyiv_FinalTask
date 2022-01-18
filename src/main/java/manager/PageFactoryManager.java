package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SearchResultPage getSearchResultPage(){return new SearchResultPage(driver);}

    public HelpAndContactPage getHelpAndContactPage(){return new HelpAndContactPage(driver);}

    public ProductPage getProductPage(){return new ProductPage(driver);}

    public SignInPage getSignInPage(){return new SignInPage(driver);}

    public WishListPage getWishListPage(){return new WishListPage(driver);}

    public SocksPage getSocksPage(){return new SocksPage(driver);}

    public MyBagPage getMayBagPage(){return new MyBagPage(driver);}
}
