package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page object model for the Delta Dental Home Page
 */
public class HomePage extends DeltaDentalBasePage {

    /** The logo locator for the home page */
    private final By logoLocator = By.id("logo");

    /** The selector for accessing the getPlans id */
    private final By getPlansLocator = By.id("getPlans");

    /**
     * Constructor for the GetAQuoteResultsPage
     * @param driver     The web driver driving the test
     * @param waitDriver The wait driver to invoke implicit waits
     */
    public HomePage(WebDriver driver, WebDriverWait waitDriver) {
        super(driver, waitDriver);
    }

    /**
     * Clicks the Get a Quote button on the home page
     * @return The GetAQuoteFormPage the button navigates to
     */
    public GetAQuoteFormPage clickGetPlans() {
        this.driver.findElement(getPlansLocator).findElement(By.xpath("./a")).click();

        GetAQuoteFormPage getAQuoteFormPage = new GetAQuoteFormPage(this.driver, this.waitDriver);
        getAQuoteFormPage.waitUntilPageLoad();

        return getAQuoteFormPage;
    }

    @Override
    public void waitUntilPageLoad() {
        this.waitDriver.until(ExpectedConditions.presenceOfElementLocated(logoLocator));
    }

}
