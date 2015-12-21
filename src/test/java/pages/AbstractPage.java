package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by daryachuiko on 19.12.15.
 */
public abstract class AbstractPage {
    protected WebDriver driver;

    public abstract void openPage();

    public AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }
}
