package hellocucumber;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        WebDriverManager.edgedriver().setup(); 
        driver = new EdgeDriver(); 
        wait = new WebDriverWait(driver, Duration.ofSeconds(18)); 
    }

    // ==============================
    // SCENARIO 1: User adds a comment (User must be signed in)
    // ==============================

    public void openHomepage() {
        System.out.println("Opening the application homepage...");
        driver.get("http://localhost:8080");
    }

    // ==============================
    // ✅ Step: Log in as a user
    // ==============================
    public void login(String username, String password) {
        System.out.println("Logging in as user...");
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a")));
        signInButton.click();

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"field-email\"]")));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"field-password\"]"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"submit-login\"]"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    // ==============================
    // ✅ Step: Navigate to the product page
    // ==============================
    public void navigateToProductPage() {
        System.out.println("Navigating to the product page...");
        WebElement chooseProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/section[1]/div/div[2]/article/div/div[1]/a/picture/img")));
        chooseProduct.click();
    }

    // ==============================
    // ✅ Step: Submit a comment
    // ==============================
    public void submitComment(String commentText) {
        System.out.println("Submitting a comment...");
        WebElement button =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"empty-product-comment\"]/button")));
        button.click();
        WebElement titleField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"comment_title\"]")));
        titleField.sendKeys("Test Comment");
        WebElement commentField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"comment_content\"]")));
        commentField.sendKeys("This is a test comment.");
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"post-product-comment-form\"]/div[2]/div[2]/button[2]"));
        submitButton.click();
        WebElement clickOk = driver.findElement(By.xpath("//*[@id=\"product-comment-posted-modal\"]/div/div/div[2]/div[2]/button"));
        clickOk.click();
        
        
        
    }

    
    public boolean isCommentSubmittedAndConfirm() {
        System.out.println("Checking if the comment was submitted...");
    
        // Check for confirmation message
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'alert-success')]")));
        boolean isDisplayed = confirmationMessage.isDisplayed();
    
        if (isDisplayed) {
            WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
            okButton.click();
        }
        return isDisplayed;
    }

    // ==============================
    // SCENARIO 2: Admin disables guest commenting
    // ==============================

    public void loginAsAdmin(String username, String password) {
        System.out.println("Logging in as admin...");
        driver.get("http://localhost:8080/admina/index.php?controller=AdminLogin&token=ee44da13e2afb3732c004af1da695896"); 

        // ✅ Use XPath for admin login form
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]"))); 
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"passwd\"]")); 
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"submit_login\"]")); 

        usernameField.sendKeys("demo@prestashop.com");
        passwordField.sendKeys("prestashop_demo");
        loginButton.click();
    }

    public void disableGuestComments() {
        System.out.println("Disabling guest comments...");

        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bo_query\"]")));
        searchBox.sendKeys("comment" + Keys.RETURN);


        WebElement module = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div[5]/table/tbody/tr/td[1]/a")));
        module.click();
        
        WebElement arrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"modules-list-container-theme_modules\"]/div/div/div/div[2]/div[4]/div[2]/button")));
        arrow.click();
        
        WebElement disableGuestCommentsToggle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"modules-list-container-theme_modules\"]/div/div/div/div[2]/div[4]/div[2]/div/li[1]/form/button")));
        disableGuestCommentsToggle.click();
        
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"module-modal-confirm-productcomments-disable\"]/div/div/div[3]/a")));
        saveButton.click();
    } 

    public boolean isGuestCommentingDisabled() {
        System.out.println("Validating if guest commenting is disabled...");
        WebElement guestCommentToggle = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@id=\"modules-list-container-theme_modules\"]/div[19]/div/div/div[2]/div[4]/div[2]/div/li[1]/form/button")));
        String toggleState = guestCommentToggle.getAttribute("class");
        return toggleState.contains("disabled") || !guestCommentToggle.isEnabled();
    }
    
    public void closeBrowser() {
        System.out.println("Closing browser...");
        if (driver != null) {
            driver.quit();
        }
    }
}
