package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by daryachuiko on 20.12.15.
 */
public class MessagePage extends AbstractPage {

    private final Logger logger = Logger.getLogger(MessagePage.class);

    private final String BASE_URL = "https://profile.onliner.by/messages";

    @FindBy(xpath = "//a[@class='vnav__create__link']")
    private WebElement writeMessage;

    @FindBy(xpath = "//span[@class='ip_i']//input[@id='compose_uname']")
    private WebElement inputName;

    @FindBy(xpath = "//span[@class='ip_i']//input[@id='compose_subject']")
    private WebElement inputTitle;

    @FindBy(xpath = "//textarea[@name='message']")
    private WebElement textMessage;

    @FindBy(xpath = "//button[@name='post']")
    private WebElement sendMessage;

    @FindBy(xpath = "//li[@id='l_sentbox']")
    private WebElement sentMessage;

    @FindBy(xpath = "//a[@href='#sentbox/129173853']")
    private WebElement titleInSent;

    @FindBy(xpath = "//sup[@id='l_sentbox_tm']")
    private WebElement countSent;

    public MessagePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Message page opened");
    }

    public void sendMessage (String reciver, String title, String text ) {
         writeMessage.click();
         inputName.sendKeys(reciver);
         inputTitle.sendKeys(title);
         textMessage.sendKeys(text);
         sendMessage.click();

    }

    public String countMessegeSent() {
        sentMessage.click();
        return countSent.getText();
    }
}
