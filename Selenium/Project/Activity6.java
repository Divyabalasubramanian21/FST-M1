package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
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
    @Parameters({ "sUsername", "sPassword" })
    public void activity6(String sUsername, String sPassword) {

        By link_my_account  = By.linkText("My Account");
        By account_title = By.xpath("//h1[contains(text(),'My Account')]");
        By login_button = By.linkText("Login");
        By click_login_button = By.id("wp-submit");
        By user_id =By.id("user_login");
        By password =By.id("user_pass");
        driver.findElement(link_my_account).click();
        String account_title_text = driver.findElement(account_title).getText();
        Assert.assertEquals(account_title_text,"My Account");
        driver.findElement(login_button).click();
        driver.findElement(user_id).sendKeys(sUsername);
        driver.findElement(password).sendKeys(sPassword);
        driver.findElement(click_login_button).click();

//
//        String getUserId =driver.findElement(By.xpath("//span[@class='display-name']")).getText();
//        Assert.assertEquals(getUserId,"root");
//        System.out.println("Login is Sucessfull");
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}