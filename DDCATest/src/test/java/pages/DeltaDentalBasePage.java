package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract page for page object models
 */
public abstract class DeltaDentalBasePage {

    /** The selenium web driver that drives the test */
    protected WebDriver driver;

    /** The selenium wait driver that makes the */
    protected WebDriverWait waitDriver;

    public DeltaDentalBasePage(WebDriver driver, WebDriverWait waitDriver) {
        this.driver = driver;
        this.waitDriver = waitDriver;
    }

    /**
     * waits for the page to load by
     * invoking an implicit wait until the element on the
     * concrete page is found
     */
    public abstract void waitUntilPageLoad();
}
