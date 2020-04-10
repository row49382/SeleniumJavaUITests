package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page object model for the GetAQuote delta dental form page
 */
public class GetAQuoteFormPage extends AbstractPage {

    /** by selector to access the form data locator */
    private final By getAQuoteFormLocator = By.id("get_a_quote");

    /** by selector to access the form data zip locator */
    private final By zipCodeInputLocator = By.id("zip");

    /** by selector to access the form data dob_day locator */
    private final By birthDayInputLocator = By.id("app0_dob_day");

    /** by selector to access the form data dob_month locator */
    private final By birthMonthInputLocator = By.id("app0_dob_month");

    /** by selector to access the form data dob_year locator */
    private final By birthYearInputLocator = By.id("app0_dob_year");

    /** by selector to access the show plans button locator */
    private final By showPlansButtonLocator = By.id("showPlans");

    /**
     * Constructor for the GetAQuoteResultsPage
     * @param driver     The web driver driving the test
     * @param waitDriver The wait driver to invoke implicit waits
     */
    public GetAQuoteFormPage(WebDriver driver, WebDriverWait waitDriver) {
        super(driver, waitDriver);
    }

    /**
     * Waits for the getAQuoteLocator to appear to get the page to load
     */
    public void waitUntilPageLoad() {
        this.waitDriver.until(ExpectedConditions.presenceOfElementLocated(this.getAQuoteFormLocator));
    }

    /**
     * Enters the zipcode and birthdate fields on the form
     * @param zipCode The zip code
     * @param birthDate The birthdate in style mm/dd/yyyy
     */
    public void enterFormData(int zipCode, String birthDate) {
        String[] birthParts = birthDate.split("/");

        this.driver.findElement(this.zipCodeInputLocator).sendKeys(Integer.toString(zipCode));
        this.driver.findElement(this.birthMonthInputLocator).sendKeys(birthParts[0]);
        this.driver.findElement(this.birthDayInputLocator).sendKeys(birthParts[1]);
        this.driver.findElement(this.birthYearInputLocator).sendKeys(birthParts[2]);
    }

    /**
     * Clicks the show plans button and loads the new page model
     * @return The GetAQuoteResultsPage model
     */
    public GetAQuoteResultsPage clickShowPlansButton() {
        this.driver.findElement(showPlansButtonLocator).click();
        GetAQuoteResultsPage getAQuoteResultsPage = new GetAQuoteResultsPage(this.driver, this.waitDriver);
        getAQuoteResultsPage.waitUntilPageLoad();

        return getAQuoteResultsPage;
    }
}
