import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activity1 extends BaseClass {

    @BeforeMethod
    public void openBrowser() {
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void verifyPageTitle() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Alchemy Jobs – Job Board Application");
        Reporter.log("Page title is " + pageTitle);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
