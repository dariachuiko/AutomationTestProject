package steps;

import org.apache.log4j.Logger;
import org.apache.log4j.pattern.MessagePatternConverter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.CurrencyExchangePage;
import pages.MainPage;
import pages.MessagePage;
import pages.AddAdPage;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.util.*;
/**
 * Created by daryachuiko on 19.12.15.
 */
public class Steps {
    private WebDriver driver;
    private String beforeCountSentMessage;

    private final Logger logger = Logger.getLogger(Steps.class);

    public void initBrowser()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Browser started");
    }

    public void closeDriver()
    {
        driver.quit();
    }

    public void loginOnliner(String username, String password)
    {
        MainPage loginPage = new MainPage(driver);

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage.openPage();
        loginPage.login(username, password);
    }

    public boolean isLoggedIn(String userid)
    {

        MainPage loginPage = new MainPage(driver);
        logger.info(loginPage.getLoggedInUserName());
        return (loginPage.getLoggedInUserName().trim().toLowerCase().equals(userid));
    }

    public void addAd(String titleAd, String textAdd,String shortText, String price)
    {
        logger.info("TEST 2");
        MainPage mainPage = new MainPage(driver);
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage.openPage();
        mainPage.addAdClick();
        AddAdPage addAdPage = new AddAdPage(driver);
        addAdPage.addAd(titleAd, textAdd, shortText, price);


    }
    public  boolean isAdded(String putTextAd)
    {
        AddAdPage addAdPage = new AddAdPage(driver);
        logger.info(addAdPage.getTextAd());
        logger.info("The text that I put" + putTextAd);
        logger.info("The text that apply after add ad"+ addAdPage.getTextAd());
        return (addAdPage.getTextAd().length() != 0);
    }

//Test3
    public void search(String text) {
        logger.info("TEST 3");
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.searchOnCatalog(text);
    }

    public boolean isSearchPopupDisplayed()
    {
        MainPage mainPage = new MainPage(driver);
        logger.info(mainPage.isSearchBarDisplayed());
        return (mainPage.isSearchBarDisplayed());
    }

// Test4
    public void currency(Integer countMany)
    {
        logger.info("TEST 4");
        MainPage mainPage = new MainPage(driver);

//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        mainPage.openPage();

        mainPage.exchangeManyClick();
        CurrencyExchangePage currencyExchangePage = new CurrencyExchangePage(driver);
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        currencyExchangePage.exchangeMany(countMany);

    }
    public boolean isTrueCorrency(Integer value)
    {

        CurrencyExchangePage currencyExchangePage = new CurrencyExchangePage(driver);

        String exchangeV = currencyExchangePage.getCorrencyValue().replaceAll(" ", "");
        int changeValue = Integer.parseInt(exchangeV);

        String afterM = Integer.toString(changeValue * value);

//        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String finalV = currencyExchangePage.getCurrencyOutValue().replaceAll(" ", "");

        logger.info("The final sum = "+ finalV);
        logger.info("The exchange value = "+ changeValue );
        logger.info("The  value = "+ value );

        return  (afterM.trim().toLowerCase().equals(finalV));

    }

//Test5
    public void sendMessage(String name, String title, String text)
    {
        logger.info("TEST 5");
        logger.info("Click on message");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnMessage();
        MessagePage messagePage = new MessagePage(driver);
        beforeCountSentMessage = messagePage.countMessegeSent();
        messagePage.sendMessage(name,title,text);
    }

    public boolean isMessageSent (String title)
    {
        MessagePage messagePage = new MessagePage(driver);
        String afterCountSent = messagePage.countMessegeSent();
        logger.info("Count before send = " + beforeCountSentMessage);
        logger.info("Count after send = " + afterCountSent);
        return (Integer.parseInt(beforeCountSentMessage) == Integer.parseInt(afterCountSent) - 1);
    }

}