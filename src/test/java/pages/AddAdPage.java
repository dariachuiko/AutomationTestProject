package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by daryachuiko on 20.12.15.
 */
public class AddAdPage extends AbstractPage {

    private final Logger logger = Logger.getLogger(MainPage.class);

    private final String BASE_URL = "http://baraholka.onliner.by/fleamarketposting.php";

    @FindBy(xpath = "//div[@class = 'i-view']//select[@name = 'f']")
    private WebElement buttonChoiceCategory;

    @FindBy(xpath = "//option[@value ='177']")
    private WebElement buttonChoiceCategoryC;

    @FindBy(xpath = "//div[@class ='ips']//div[@class = 'i-view']//input[@type ='text']")
    private WebElement titleAd;

    @FindBy(xpath = "//div[@class ='resizable-textarea']//textarea[@id ='message']")
    private WebElement textAd;

    @FindBy(xpath = "//div[@class ='resizable-textarea']//textarea[@name ='topic_desc']")
    private WebElement shortTextAd;

    @FindBy(xpath = "//h1[@class='m-title-i title']")
    private WebElement titleTextAd;

    @FindBy(xpath = "//div[@class='i-view']//input[@class='i-p ip-cost']")
    private WebElement productPrice;

    @FindBy(xpath = "//img[@src ='/static/img/btn-addof.png']")
    private WebElement buttonAdd;

    public AddAdPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Addad page opened");
    }
    public void addAd(String title, String text, String shortText, String price)
    {
        buttonChoiceCategory.click();
        buttonChoiceCategoryC.click();
        titleAd.sendKeys(title);
        textAd.sendKeys(text);
        shortTextAd.sendKeys(shortText);
        productPrice.sendKeys(price);
        buttonAdd.click();

    }

    public String getTextAd()
    {
        return titleTextAd.getText();
    }

}