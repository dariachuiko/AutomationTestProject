package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.concurrent.TimeUnit;

/**
 * Created by daryachuiko on 19.12.15.
 */
public class MainPage extends AbstractPage {

    private final Logger logger = Logger.getLogger(MainPage.class);

    private final String BASE_URL = "http://www.onliner.by/#login";

    @FindBy(xpath = "//div[@class ='auth-bar__item auth-bar__item--text']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//div[@class = 'auth-box__line']//input[@type='text']")
    private WebElement inputLogin;

    @FindBy(xpath = "//div[@class = 'auth-box__line']//input[@type='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//div[@class = 'auth-box__line auth-box__line--final']//button[@class = 'auth-box__auth-submit auth__btn auth__btn--green']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//ul[@class ='b-main-navigation']//li[@class ='b-main-navigation__item']//a[@href ='http://baraholka.onliner.by/']")
    private WebElement buttonBoroholka;

    @FindBy(xpath = "//a[@class = 'b-btn-fleamarket__1']")
    private WebElement buttonAddAd;

    @FindBy(xpath = "//p[@class = 'user-name']")
    private WebElement linkLoggedInUser;

    @FindBy(xpath = "//input[@class='fast-search__input']")
    private WebElement searchField;

    @FindBy(xpath = "//iframe[@class='modal-iframe']")
    private WebElement el;

    //4
    @FindBy(xpath = "//a[@href='http://kurs.onliner.by/']")
    private WebElement exchange; //current cource

    //5
    @FindBy(xpath = "//a[@href='https://profile.onliner.by/messages']")
    private WebElement buttonMessage; // Button message


    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        driver.manage().window().maximize();
        logger.info("Main page opened");
    }


    public void login(String username, String password)
    {
        buttonLogin.click();
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Login performed");
    }

    public String getLoggedInUserName()
    {
        return linkLoggedInUser.getText();
    }



    public void addAdClick()
    {
        buttonBoroholka.click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        buttonAddAd.click();
    }



    public void searchOnCatalog(String searchText)
    {
      searchField.sendKeys(searchText);
      logger.info("Search performed");
    }

    public boolean isSearchBarDisplayed()
    {
        return el.isDisplayed();
    }



    public void exchangeManyClick() {
        exchange.click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



    public void clickOnMessage()
    {
       buttonMessage.click();
    }
}
