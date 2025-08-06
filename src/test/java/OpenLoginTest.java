import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class OpenLoginTest {

    public static WebDriver driver; // make static so DashboardPage can reuse it
    public static WebDriverWait wait;

    @Test
    public void loginTest() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Open the URL
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().window().maximize();

            // Wait for username field to be visible
            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

            // Input credentials
            username.sendKeys("Admin");
            password.sendKeys("admin123");

            // Click login button
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();

            // Optional: Wait to confirm login success
            wait.until(ExpectedConditions.urlContains("/dashboard"));

            System.out.println("✅ Login Test Passed");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Login Test Failed");
        }
    }
}
