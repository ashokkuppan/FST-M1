import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class activity4 extends BaseClass {

    @BeforeMethod
    public void openBrowser() {
        driver.get("https://alchemy.hguy.co/jobs/");
        new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void verifySecondHeading() {
        WebElement title = driver.findElement(By.xpath("//h2"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String secondHeading = title.getText();
        Assert.assertEquals(secondHeading, "Quia quis non");
        System.out.println("Second Heading title is " + secondHeading);
        Reporter.log("Second Heading title is " + secondHeading);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
