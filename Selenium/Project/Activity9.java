package seleniumProject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
public class CompleteLesson_9 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        driver.findElement(By.xpath("//a[contains(text(),'All Courses')]")).click();
        Thread.sleep(80);
        String Title = driver.getTitle();
        System.out.println(" Page 1 Title = " + Title);
        driver.findElement(By.xpath("//*[@id=\"post-71\"]/div[2]/p[2]")).click();
        driver.findElement(By.className("ld-button")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        // Click Courses
        driver.findElement(By.xpath("//*[@id=\"ld-expand-91\"]/div/a/div[2]")).click();
        String T1 = driver.getTitle();
        String T2 = "Deliverability Of Your Emails – Alchemy LMS";
        System.out.println("Page 2 Title = " + T1 );
        Assert.assertEquals(T1, T2);
        if(driver.findElements(By.xpath("//*[@id=\"learndash_post_91\"]/div/div[3]/div[2]/form/input[4]")).isEmpty()){
            // Then click on the mark complete button
            //driver.findElement(By.xpath("//*[@id=\"learndash_post_91\"]/div/div[3]/div[2]/form/input[4]")).click();
            System.out.println("Course is already completed. Hence Mark complete button not present");
            driver.close();
        }
        else{
            driver.findElement(By.xpath("//*[@id=\"learndash_post_91\"]/div/div[3]/div[2]/form/input[4]")).click();
            System.out.println("Course successfully completed");
            driver.close();
        }
    }
}







