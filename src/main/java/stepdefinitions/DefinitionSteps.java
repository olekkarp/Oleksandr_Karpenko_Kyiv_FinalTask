package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;
import static org.junit.Assert.*;


public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 90;

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    SearchResultPage searchResultPage;
    HelpAndContactPage helpAndContactsPage;
    ProductPage productPage;
    SignInPage signInPage;
    WishListPage wishListPage;
    SocksPage socksPage;
    MyBagPage myBagPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User opens {string} page")
    public void openPage(final String url){
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks header visibility")
    public void headerVisibility(){
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isHeaderVisible();
    }

    @And("User checks main content visibility")
    public void mainContentVisibility(){
    homePage.isMainContentVisible();
    }

    @And("User checks footer visibility")
    public void footerVisibility(){
        homePage.isFooterVisible();
    }

    @And("User checks shopping cart visibility")
    public void shoppingCartVisibility(){
        homePage.isShoppingCartVisible();
    }

    @And("User checks my account icon visibility")
    public void myEbayIconVisibility(){
        homePage.isMyAccountIconVisible();
    }

    @And("User checks input field visibility")
    public void inputFieldVisibility(){
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isInputFieldVisible();
    }

    @And("User checks search button visibility")
    public void searchButtonVisibility(){
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isSearchButtonVisible();
    }

    @And("User checks main container of category visibility")
    public void mainContainerOfCategoryVisibility(){
        homePage.isMainContainerOfCategoryVisible();
    }

    @And("User checks asos logo visibility")
    public void ebayLogoVisibility(){
        homePage.isAsosLogoVisible();
    }

    @And("User enters search {string}")
    public void enterTextToSearchField(final String keyword){
        homePage.searchByKeyword(keyword);
    }

    @And("User clicks search button")
    public void clickOnSearchButton(){
        homePage.clickOnSearchButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        searchResultPage = pageFactoryManager.getSearchResultPage();
    }

    @And("User checks first product visibility")
    public void firstProductVisibility(){
        searchResultPage = pageFactoryManager.getSearchResultPage();
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getFirstProductIcon());
        searchResultPage.isFirstProductVisible();
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks the title include {string}")
    public void userChecksTheTitleIncludeKeyword(final String keyword) {
        assertTrue(searchResultPage.getTextFromFirstTitle().contains(keyword));
    }

    @And("User checks help and contact visibility")
    public void helpAndContactVisibility(){
        homePage.isHelpAndContactsVisible();
    }

    @And("User clicks help and contact button")
    public void userClicksHelpAndContact(){
        homePage.clickOnHelpButton();
        helpAndContactsPage = pageFactoryManager.getHelpAndContactPage();
        helpAndContactsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        helpAndContactsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, helpAndContactsPage.getSearchField());
    }

    @And("User enter question {string}")
    public void enterQuestion(final String question){
        helpAndContactsPage.enterQuestion(question);
        helpAndContactsPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        helpAndContactsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks search field visibility")
    public void checkSearchFieldVisibility(){
        helpAndContactsPage.isSearchFieldVisible();
    }

    @And("User checks help page titles include {string}")
    public void checkHelpPageTitles(final String question){
        for (WebElement webElement : helpAndContactsPage.getTitleTextList())
        {assertTrue(webElement.getText().contains(question));}
    }

    @And("User checks search lists visibility")
    public void checkSearchListsVisibility(){
        helpAndContactsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, helpAndContactsPage.getSearchLists());
        helpAndContactsPage.isSearchListsVisible();
    }

    @And("User checks filters visibility")
    public void checkFiltersVisibility(){
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getFilters());
        searchResultPage.isFiltersVisible();
    }
    @And("User enter grey colour in filters")
    public void clickOnPriceFilters(){
        searchResultPage.clickOnColourFilter();
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getColourFilterList());
        searchResultPage.clickOnGreyColour();
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickOnColourFilter();
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getGreyHoodie());
    }

    @And("User checks grey hoodie visibility")
    public void checkGreyHoodieVisibility(){
        searchResultPage.isGreyProductVisible();
    }

    @And("User click on add to wish list grey hoodie")
    public void clickOnAddToWishListGreyHoodie(){
        searchResultPage.clickOnAddGreyHoodieWishlist();
    }

    @And("User clicks on wish list")
    public void clickOnWishListButton() {
        searchResultPage.clickOnWishListButton();
        wishListPage = pageFactoryManager.getWishListPage();
        wishListPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, wishListPage.getProductSection());
    }

    @And("User checks product in wish list visibility")
    public void checkGreyHoodieInWishListVisibility(){
        assertTrue(wishListPage.isProductSectionVisible());
    }

    @And("User clicks on first product")
    public void clickOnFirstProduct(){
        searchResultPage.clickOnFirstProductIcon();
        productPage = pageFactoryManager.getProductPage();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getImageProduct());
    }

    @And("User checks image product visibility")
    public void checkImageProductVisibility(){
        productPage.isImageProductVisible();
    }

    @And("User clicks add to bag")
    public void clickAddToBag(){
        productPage.clickOnAddToBag();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks bag")
    public void checkBag(){
        productPage.clickOnBagFilled();
        productPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(productPage.getTextInMyBag().contains("New Balance"));
    }

    @Then("User checks error massage")
    public void userChecksErrorMassage() {
        productPage.isErrorMessageVisible();
    }

    @And("User check hoodie")
    public void checkHoodie(){
        searchResultPage = pageFactoryManager.getSearchResultPage();
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.isProductHoodieVisible();
    }

    @And("User clicks my account")
    public void clickMyAccount(){
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickOnMyAccount();
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage = pageFactoryManager.getSignInPage();
    }

    @And("User checks form visibility")
    public void checkFormVisibility(){
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getSignInForm());
        signInPage.isSignInOptionsVisible();
        signInPage.isSignInWithVisible();
        signInPage.isSignInFormVisible();
    }

    @And("User enters {string}")
    public void enterEmail(final String email){
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.enterEmail(email);
        signInPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User clicks sign in")
    public void clickSignIn(){
        signInPage.clickOnSignInButton();
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getErrorMessage());
    }

    @And("User checks error message")
    public void checkErrorMassage(){
        signInPage.isErrorMessageVisible();
    }

    @And("User clicks socks in clothing category")
    public void clickOnSocksInClothingCategory(){
        homePage.clickSocksInClothingCategory();
        socksPage = pageFactoryManager.getSocksPage();
        socksPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, socksPage.getSocksProducts());
    }

    @And("User checks socks product visibility")
    public void checkSocksProductVisibility(){socksPage.isSocksProductsVisible();}

    @And("User clicks no size socks")
    public void clickNoSizeSocks(){
        socksPage.clickOnNoSizeButton();
        socksPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, socksPage.getSocksProducts());
    }

    @And("User clicks socks product icon")
    public void clickSocksProduct(){
        socksPage.clickOnSocksProduct();
        productPage = pageFactoryManager.getProductPage();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getImageProduct());
    }

    @And("User checks my bag dropdown")
    public void checkMyBagDropDown(){
        productPage.clickMyBagDropDown();
        assertTrue(productPage.getTextInMyBag().contains("socks"));
    }

    @And("User clicks view bag")
    public void clickViewBag(){
        productPage.clickMyBagDropDown();
        productPage.clickOnViewBagButton();
        myBagPage = pageFactoryManager.getMayBagPage();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, myBagPage.getProductIconInMyBag());
    }

    @And("User checks product in my bag visibility")
    public void checkProductInMyBagVisibility(){
        myBagPage.isProductIconInMyBagVisible();
    }

    @And("User click remove product button")
    public void clickRemoveProductButton(){
        myBagPage.clickOnRemoveProductButton();
        myBagPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, myBagPage.getBagContents());
    }

    @And("User checks that my bag empty")
    public void checkMyBagEmpty(){
        assertTrue(myBagPage.getTextFromBagContents().contains("empty"));
    }

    @And("User click in adidas in shoes category")
    public void clickAdidasInShoesCategory(){
        homePage.clickAdidasByShoesCategory();
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getHeadingAdidas());
    }

    @And("User checks adidas header visibility")
    public void checkAdidasHeaderVisibility(){
        searchResultPage.isHeadingAdidasVisible();
    }

    @And("User checks products descriptions include adidas")
    public void checkProductsDescriptionsIncludeAdidas(){
        for (WebElement webElement: searchResultPage.getTextProductsList()){
            assertTrue(webElement.getText().contains("adidas"));
        }
    }

    @And("User clicks shipping restrictions")
    public void clickShippingRestrictions(){
        productPage.clickOnShippingRestrictions();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getShippingRestrictionsIcon());
    }

    @And("User enters {string} in search field")
    public void enterCountryInSearchField(final String country){
        productPage.enterShippableCountriesSearch(country);
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getErrorSearchCountryMassage());
    }


    @And("User checks error search country massage")
    public void checkErrorSearchCountryMessage(){
        productPage.isErrorSearchCountryMassageVisible();
        assertTrue(productPage.getErrorSearchCountryMassage().getText().contains("no matching results"));
    }

    @And("User enters password {string}")
    public void userEntersPasswordPassword(final String password) {
        signInPage.enterPassword(password);
    }
}
