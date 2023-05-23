package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
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
    public void activity5() {

        By link_my_account  = By.linkText("My Account");
        By account_title = By.xpath("//h1[contains(text(),'My Account')]");
        driver.findElement(link_my_account).click();
        String sccount_title_text = driver.findElement(account_title).getText();
        Assert.assertEquals(sccount_title_text,"My Account");


    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}