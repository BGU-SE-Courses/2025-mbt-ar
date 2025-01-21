package hellocucumber;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GuestCommentsSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    // ✅ Constructor initializes Selenium WebDriver
    public GuestCommentsSteps() {
        WebDriverManager.edgedriver().setup(); // ✅ Automatically downloads correct WebDriver
        driver = new EdgeDriver(); // ✅ Launches Edge browser
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ Waits up to 10 seconds for elements
    }

    // ==============================
    // SCENARIO 1: User adds a comment (User must be signed in)
    // ==============================

    public void loginAsUser(String username, String password) {
        System.out.println("Logging in as user...");
        driver.get("http://localhost:8080/login"); 

        // ✅ Click on sign-in button
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='_desktop_user_info']/div/a")));
        signInButton.click();

        // ✅ Use XPath for user login form
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"field-email\"]"))); // ❌ INSERT CORRECT XPATH HERE
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"field-password\"]")); // ❌ INSERT CORRECT XPATH HERE
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"submit-login\"]")); 

        usernameField.sendKeys("bar.pesso26@gmail.com");
        passwordField.sendKeys("123456789ABCDEF!");
        loginButton.click();
    }

    public void navigateToProductPage() {
        System.out.println("Navigating to the product page...");
        driver.get("http://localhost:8080/men/1-1-hummingbird-printed-t-shirt.html#/1-size-s/8-color-white"); // ✅ Replace with actual URL
    }

    public void submitComment(String commentText) {
        System.out.println("Submitting a user comment...");

        // ✅ Use XPath for locating elements
        WebElement titleField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"comment_title\"]")));
        WebElement commentField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"empty-product-comment\"]/button"))); 
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"post-product-comment-form\"]/div[2]/div[2]/button[2]")); 
        titleField.sendKeys("Test Comment");
        commentField.sendKeys("Hello, this is a test comment.");
        submitButton.click();
    }

    public boolean isCommentSubmittedAndConfirm() {
        System.out.println("Checking if the comment was submitted...");

        // ✅ Use XPath for confirmation message
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert-success']"))); // ❌ INSERT CORRECT XPATH HERE
        boolean isDisplayed = confirmationMessage.isDisplayed();
        if (isDisplayed) {
            WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"product-comment-posted-modal\"]/div/div/div[2]/div[2]/button"))); // ❌ INSERT CORRECT XPATH HERE
            okButton.click();
        }
        return isDisplayed;
    }

    // ==============================
    // SCENARIO 2: Admin disables guest commenting
    // ==============================

    public void loginAsAdmin(String username, String password) {
        System.out.println("Logging in as admin...");
        driver.get("http://localhost:8080/prestashop/admin-login-url"); // ✅ Replace with actual admin URL

        // ✅ Use XPath for admin login form
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']"))); // ❌ INSERT CORRECT XPATH HERE
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']")); // ❌ INSERT CORRECT XPATH HERE
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='login-button']")); // ❌ INSERT CORRECT XPATH HERE

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void disableGuestComments() {
        System.out.println("Disabling guest comments...");

        // ✅ Use XPath for settings menu
        WebElement settingsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[@id='settings-menu']"))); // ❌ INSERT CORRECT XPATH HERE
        WebElement disableGuestCommentsToggle = driver.findElement(By.xpath("//input[@id='disable-guest-comments-toggle']")); // ❌ INSERT CORRECT XPATH HERE
        WebElement saveButton = driver.findElement(By.xpath("//button[@id='save-settings-button']")); // ❌ INSERT CORRECT XPATH HERE

        settingsMenu.click();
        disableGuestCommentsToggle.click();
        saveButton.click();
    }

    public boolean isGuestCommentingDisabled() {
        System.out.println("Checking if guest comments are disabled...");
        driver.get("http://localhost:8080/prestashop/product-page-url"); // Reload page

        // ✅ Use XPath for comment input field
        WebElement commentField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@name='comment']"))); // ❌ INSERT CORRECT XPATH HERE
        return !commentField.isEnabled();
    }

    // ✅ Close browser after tests
    public void closeBrowser() {
        System.out.println("Closing browser...");
        if (driver != null) {
            driver.quit();
        }
    }
}
