import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activity3 extends BaseClass {

    @BeforeMethod
    public void openBrowser() {
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void verifyHeaderImage() {
        WebElement img = driver.findElement(By.xpath("//div/img"));
        String imageURL = img.getAttribute("src");
        System.out.println(imageURL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
