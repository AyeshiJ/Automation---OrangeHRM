import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AdminTest {

    @Test(dependsOnMethods = {"OpenLoginTest.loginTest"})
    public void clickAdminAfterLogin() {
        try {
            // Click Admin tab
            WebElement adminTab = OpenLoginTest.wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admin']"))
            );
            adminTab.click();
            System.out.println("✅ Clicked Admin tab successfully.");

            // Click Add button
            WebElement addButton = OpenLoginTest.wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add']"))
            );
            addButton.click();
            System.out.println("✅ Clicked Add button successfully.");

            // Click User Role dropdown to open options
            WebElement userRoleDropdown = OpenLoginTest.wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='User Role']/following::div[contains(@class,'oxd-select-text-input')][1]"))
            );
            userRoleDropdown.click();

            // Wait for and click the desired option, e.g. "Admin"
            WebElement userRoleOption = OpenLoginTest.wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='listbox']//span[text()='Admin']"))
            );
            userRoleOption.click();
            System.out.println("✅ Selected User Role 'Admin' successfully.");

            // Fill Employee Name input box (autocomplete)
            WebElement employeeNameInput = OpenLoginTest.wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Employee Name']/following::input[1]"))
            );
            employeeNameInput.sendKeys("John");

            // Wait for the dropdown option to appear and click the first match
            WebElement autoSuggestion = OpenLoginTest.wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='listbox']//span"))
            );
            autoSuggestion.click();
            System.out.println("✅ Selected Employee Name from autocomplete dropdown.");

            // Click User Status to open options
            WebElement statusDropdown = OpenLoginTest.wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Status']/following::div[contains(@class,'oxd-select-text-input')][1]"))
            );
            statusDropdown.click();

            // Wait for and click the desired option, e.g. "Enabled"
            WebElement statusOption = OpenLoginTest.wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='listbox']//span[text()='Enabled']"))
            );
            statusOption.click();
            System.out.println("✅ Selected Status 'Enabled' successfully.");

            // Fill UserName input box
            WebElement userNameInput = OpenLoginTest.wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Username']/following::input[1]"))
            );
            userNameInput.sendKeys("Test User");
            System.out.println("✅ Filled User Name 'Test User' successfully.");

            // Fill Password
            WebElement passwordInput = OpenLoginTest.wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Password']/following::input[1]"))
            );
            passwordInput.sendKeys("Password123!");
            System.out.println("✅ Filled Password successfully.");

            // Fill Confirm Password
            WebElement confirmPasswordInput = OpenLoginTest.wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Confirm Password']/following::input[1]"))
            );
            confirmPasswordInput.sendKeys("Password123!");
            System.out.println("✅ Filled Confirm Password successfully.");

            // Click the Save button
            WebElement saveButton = OpenLoginTest.wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Save']"))
            );
            saveButton.click();
            System.out.println("✅ Clicked Save button successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Failed in Admin tab, Add button, User Role selection or Employee Name input.");
        }
    }
}
