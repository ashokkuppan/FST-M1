import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class activity6 extends BaseClass {

    @BeforeMethod
    public void openBrowser() {
        driver.get("https://alchemy.hguy.co/jobs/jobs/");
        new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void verifyApplyToaJob() {
        WebElement keywordsTxtBox = driver.findElement(By.xpath("//input[contains(@id, 'search_keywords')]"));
        keywordsTxtBox.sendKeys("Banking");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement searchBtn = driver.findElement(By.xpath("//input[contains(@type, 'submit')]"));
        searchBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement firstJobList = driver.findElement(By.xpath("//h3[contains(text(), 'SAP Testing')]"));
        firstJobList.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement applyJobBtn = driver.findElement(By.xpath("//input[contains(@type, 'button')]"));
        applyJobBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement getEmailID = driver.findElement(By.xpath("//a[contains(@class, 'job_application_email')]"));
        String EmailID = getEmailID.getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(EmailID, "abc@gmail.com");
        System.out.println("Email ID is " + EmailID);
        Reporter.log("Email ID is " + EmailID);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
