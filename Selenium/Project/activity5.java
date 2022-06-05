import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class activity5 extends BaseClass {

    @BeforeMethod
    public void openBrowser() {
        driver.get("https://alchemy.hguy.co/jobs/");
        new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void verifyPageNavigation() {
        WebElement jobsMenu = driver.findElement(By.xpath("(//a[contains(text(), 'Jobs')])[2]"));
        jobsMenu.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Jobs – Alchemy Jobs");
        System.out.println("Jobs page title is " + pageTitle);
        Reporter.log("Jobs page title is " + pageTitle);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
