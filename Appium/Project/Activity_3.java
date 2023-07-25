package Project_Appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Activity_3 {

    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("s");

        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        driver.get("https://www.training-support.net/selenium");

    }

    // Test method
    @Test
    public void googleChrome() {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

        driver.findElement(AppiumBy.xpath("//android.view.View"));

        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));

        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"To-Do List \uF0AE Elements get added at run time\"]")).click();

        driver.findElement(AppiumBy.xpath("android.view.View/android.view.View[3]")).click();

        WebElement textbox = driver.findElement(AppiumBy.id("taskInput"));
        textbox.click();

        //Task 1
        textbox.sendKeys("Add tasks to list");

        WebElement addtask = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));
        addtask.click();

        //Task 2
        textbox.click();
        textbox.sendKeys("Get number of tasks");
        addtask.click();

        //Task 3
        textbox.click();
        textbox.sendKeys("Clear the list");
        addtask.click();

        //Striking Task 1
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Add tasks to list']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get number of tasks']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Clear the list']")).click();

        //Click on Clear List
        driver.findElement(AppiumBy.xpath("//android.view.View/android.view.View[3]")).click();


        List<WebElement> AfterElements = driver.findElements(AppiumBy.className("android.widget.TextView"));
        System.out.println("Edit Text Class elements : " + AfterElements.size());
        for(WebElement AfterElement:AfterElements){
            System.out.println(AfterElement.getText());
        }
        int ListAfterDeleting = AfterElements.size();
        Assert.assertEquals(ListAfterDeleting,5);

    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
}
}

