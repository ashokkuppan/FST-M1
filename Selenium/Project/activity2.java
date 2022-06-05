import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activity2 extends BaseClass {

    @BeforeMethod
    public void openBrowser() {
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void verifyHeadingTitle() {
        WebElement title = driver.findElement(By.xpath("//h1[contains(text(),'Welcome to Alchemy Jobs')]"));
        String headingTitle = title.getText();
        Assert.assertEquals(headingTitle, "Welcome to Alchemy Jobs");
        Reporter.log("Page title is " + headingTitle);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
