package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
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
    public void activity4() {
        // Check the title of the page
        By title_2nd_course  = By.xpath("//h3[contains(text(),'Email Marketing Strategies')]");
        String title_of_2nd_course = driver.findElement(title_2nd_course).getText();
        System.out.println("Title  of the second popular course   is: " + title_of_2nd_course);
        Assert.assertEquals("Email Marketing Strategies", title_of_2nd_course);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}