package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {
    // Declare the WebDriver object
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void activity8() throws InterruptedException {

        By link_contact  = By.linkText("Contact");
        By FullName = By.id("wpforms-8-field_0");
        By email = By.id("wpforms-8-field_1");
        By subject = By.id("wpforms-8-field_2");
        By comment = By.id("wpforms-8-field_3");
        By Btn_Sendmessage = By.id("wpforms-submit-8");

        driver.findElement(link_contact).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FullName));
        driver.findElement(FullName).sendKeys("Divya Balasubramanian");
        driver.findElement(email).sendKeys("test1@mail.com");
        driver.findElement(subject).sendKeys("Training");
        driver.findElement(comment).sendKeys("Feedback");
        driver.findElement(Btn_Sendmessage).click();
        String confirmation_msg = driver.findElement(By.id("wpforms-confirmation-8")).getText();
        System.out.println(confirmation_msg);
        Assert.assertEquals("Thanks for contacting us! We will be in touch with you shortly.",confirmation_msg);

    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}