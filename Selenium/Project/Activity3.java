package TestNG;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity3 {
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
    public void activity3() {
        // Check the title of the page
        By title_first_box  = By.xpath("//h3[contains(text(),'Actionable Training')]");
        String title_of_first_box = driver.findElement(title_first_box).getText();
        System.out.println("Title  of the first box   is: " + title_of_first_box);
        Assert.assertEquals("Actionable Training", title_of_first_box);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}