package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity7 {
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
    public void activity7() throws InterruptedException {

        By link_all_courses  = By.linkText("All Courses");
        By list_of_course = By.xpath("//div[@class='ld-course-list-items row']/div");
        driver.findElement(link_all_courses).click();
        Thread.sleep(100);
        int sccount_title_text = driver.findElements(By.xpath("//div[@class='ld-course-list-items row']/div")).size();
        System.out.println("The number of course available is : "+sccount_title_text);


    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}