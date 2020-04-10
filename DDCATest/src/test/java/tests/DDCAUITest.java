package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.DeltaDentalHomePage;
import pom.GetAQuoteFormPage;
import pom.GetAQuoteResultsPage;

/**
 * UI Selenium Tests for the DDCA homepage
 */
public class DDCAUITest {

    /** home url of the site under test */
    private final String HOME_URL = "https://www.deltadentalins.com/";

    /** The web driver performing the test */
    private WebDriver driver;

    /** The wait driver invoking explicit waits on the driver */
    private WebDriverWait wait;

    /**
     * starts the web driver at the delta dental home page
     */
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(this.driver, 10);

        this.driver.get(HOME_URL);
    }

    /**
     * closes the web driver when the test is complete
     */
    @AfterMethod
    public void teardown() {
        this.driver.quit();
    }

    /**
     * Gets the DDCA dental plans with the provided zipcode and birthdate
     */
    @Test
    public void testGetDentalPlans() {
        int zipCode = 94105;
        String birthdate = "06/10/1995";

        DeltaDentalHomePage homePage = new DeltaDentalHomePage(this.driver, this.wait);
        GetAQuoteFormPage getAQuoteFormPage = homePage.clickGetPlans();

        getAQuoteFormPage.enterFormData(zipCode, birthdate);
        GetAQuoteResultsPage getAQuoteResultsPage = getAQuoteFormPage.clickShowPlansButton();

        String plans = getAQuoteResultsPage.getAllPlans()
                // reduce the results to readable formatted string
                .reduce("\nDelta Dental Plans Found: \n" , (x, y) -> x + y + "\n");

        // using the TestNG reporting to write the console
        Reporter.log(plans, true);
        Assert.assertNotNull(plans, "no plans were found");
    }
}
