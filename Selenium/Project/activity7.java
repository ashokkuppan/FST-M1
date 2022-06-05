import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class activity7 extends BaseClass {

    @BeforeMethod
    public void openBrowser() {
        driver.get("https://alchemy.hguy.co/jobs/");
        new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void verifyPageNavigation() {
        WebElement postaJobMenu = driver.findElement(By.xpath("//a[contains(text(), 'Post a Job')]"));
        postaJobMenu.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement yourEmail = driver.findElement(By.xpath("//input[contains(@id, 'create_account_email')]"));
        yourEmail.sendKeys("ashok5.k@test.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement jobTitle = driver.findElement(By.xpath("//input[contains(@id, 'job_title')]"));
        jobTitle.sendKeys("Test Selenium Job Post");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement URL = driver.findElement(By.xpath("//input[contains(@id, 'application')]"));
        URL.sendKeys("https://alchemy.hguy.co/jobs/post-a-job/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement companyName = driver.findElement(By.xpath("//input[contains(@id, 'company_name')]"));
        companyName.sendKeys("Test Selenium Job Post");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement Description = driver.findElement(By.xpath("//iframe[contains(@id, 'job_description_ifr')]"));
        Description.sendKeys("Test Selenium Job Post");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement previewBtn = driver.findElement(By.xpath("//input[contains(@name, 'submit_job')]"));
        previewBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement submitListingBtn = driver.findElement(By.xpath("//input[contains(@id, 'job_preview_submit_button')]"));
        submitListingBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement jobsMenu = driver.findElement(By.xpath("(//a[contains(text(), 'Jobs')])[3]"));
        jobsMenu.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement keywordsTxtBox = driver.findElement(By.xpath("//input[contains(@id, 'search_keywords')]"));
        keywordsTxtBox.sendKeys("Test Selenium Job Post");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement searchBtn = driver.findElement(By.xpath("(//input[contains(@type, 'submit')])[2]"));
        searchBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement firstJobList = driver.findElement(By.xpath("(//h3)[1]"));
        String jobPostTitle = firstJobList.getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("Job title is " + jobPostTitle);
        Reporter.log("Job title is " + jobPostTitle);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
