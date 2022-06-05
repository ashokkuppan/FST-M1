import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class activity8 extends BaseClass{

    @BeforeMethod
    public void openBrowser() {
        driver.get("https://alchemy.hguy.co/jobs/wp-login.php");
        new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void verifyPageNavigation() {
        WebElement userName = driver.findElement(By.xpath("//input[contains(@id,'user_login')]"));
        userName.sendKeys("root");
        WebElement passWord = driver.findElement(By.xpath("//input[contains(@id,'user_pass')]"));
        passWord.sendKeys("pa$$w0rd");
        WebElement loginBtn = driver.findElement(By.xpath("//input[contains(@id,'wp-submit')]"));
        loginBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Dashboard ‹ Alchemy Jobs — WordPress");
        System.out.println("Backend page title is " + pageTitle);
        Reporter.log("Backend page title is " + pageTitle);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
