package TestNG;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity2 {
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
    public void activity2() {
        // Check the title of the page
        By heading  = By.xpath("//h1[contains(text(),'Learn from Industry Experts')]");
        String heading_text = driver.findElement(heading).getText();
        System.out.println("Heading of the page  is: " + heading_text);
        Assert.assertEquals("Learn from Industry Experts", heading_text);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}