package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.stream.Stream;

/**
 * Page object model for the results page after submitting
 * the form data from the GetAQuoteFormPage
 */
public class GetAQuoteResultsPage extends AbstractPage {

    /** by selector to access the selctor anchor element in the plan results */
    private final By planOptionsSectionSelector = By.xpath("//section");

    /** The plan options box header for locating all plan options */
    private final By planOptionsBoxHeader = By.className("plan-options-box__title");

    /**
     * Constructor for the GetAQuoteResultsPage
     * @param driver     The web driver driving the test
     * @param waitDriver The wait driver to invoke implicit waits
     */
    public GetAQuoteResultsPage(WebDriver driver, WebDriverWait waitDriver) {
        super(driver, waitDriver);
    }

    /**
     * Gets all the plans from the results in the form page
     * @return The name of the plans available
     */
    public Stream<String> getAllPlans() {
        return this.driver
                .findElement(this.planOptionsSectionSelector)
                .findElements(this.planOptionsBoxHeader)
                .stream()
                .map(WebElement::getText);
    }

    @Override
    public void waitUntilPageLoad() {
        this.waitDriver.until(ExpectedConditions.presenceOfElementLocated(this.planOptionsSectionSelector));
    }
}
