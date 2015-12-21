package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;

import java.security.Key;
import java.util.concurrent.TimeUnit;

/**
 * Created by daryachuiko on 20.12.15.
 */
public class CurrencyExchangePage extends AbstractPage {

    private final Logger logger = Logger.getLogger(CurrencyExchangePage.class);

    private final String BASE_URL = "http://kurs.onliner.by/";

    @FindBy(xpath = "//div[@class='amount-i']//input[@name='amount-in']")
    private WebElement manyCount;

    @FindBy(xpath = "//select[@name='currency-out']//option[@dev='RUB']")
    private WebElement choiceСurrencyOut;

    @FindBy(xpath = "//b[@class='js-cur-result']")
    private WebElement valueСurrencyOut;

    @FindBy(xpath = "//li[@class='bank to-be-removed']//b")
    private WebElement bestCource;

    public CurrencyExchangePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("CurrencyExchange page opened");
    }

    public void exchangeMany(Integer value) {
        manyCount.clear();
        manyCount.sendKeys(value+"");
        manyCount.sendKeys(Keys.ARROW_RIGHT);
        manyCount.sendKeys(Keys.BACK_SPACE);
        logger.info("Currency exchange performed");
    }

    public String getCurrencyOutValue()
    {
        return valueСurrencyOut.getText();
    }

    public String getCorrencyValue()
    {
        return bestCource.getText();
    }

}
