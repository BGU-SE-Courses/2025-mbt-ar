package hellocucumber;



import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GuestCommentsStepDefinitions {
    private GuestCommentsSteps guestSteps = new GuestCommentsSteps();

       // ==============================
    // ✅ Background: Open product page
    // ==============================

    @Given("the product page is open")
    public void userStartsOnHomepage() {
        System.out.println("The user starts on the application homepage...");
        guestSteps.openHomepage();
    }

    // ==============================
    // Scenario 1: Guest successfully adds a comment
    // ==============================

    @Given("a guest user logs in and navigates to a product page")
    public void guestUserLogsInAndNavigatesToProduct() {
        System.out.println("Logging in as a guest and navigating to the product page...");
        guestSteps.openHomepage();
        guestSteps.login("bar.pesso26@gmail.com", "123456789ABCDEF!"); // Replace with test credentials
        guestSteps.navigateToProductPage();
    }

    @When("the guest submits a comment")
    public void guestSubmitsComment() {
        System.out.println("Submitting a comment as a guest...");
        guestSteps.submitComment("This is a test comment."); // Replace with test comment
    }

    @Then("the comment should be submitted successfully")
    public void commentSubmissionVerified() {
        System.out.println("Verifying that the comment was successfully submitted...");
        boolean isCommentSubmitted = guestSteps.isCommentSubmittedAndConfirm();
        assertTrue(isCommentSubmitted, "Error: The comment was not submitted successfully.");
    }
    // ==============================
    // SCENARIO 2: Admin disables guest commenting
    // ==============================

    @Given("an admin is logged into the admin panel")
    public void adminLoggedIn() {
        guestSteps.loginAsAdmin("admin", "admin-password");
    }

    @When("the admin disables guest comments in the settings")
    public void adminDisablesGuestComments() {
        guestSteps.disableGuestComments();
    }

    @Then("the guest comment functionality should be disabled")
    public void guestCommentsDisabled() {
        guestSteps.isGuestCommentingDisabled();
        guestSteps.closeBrowser(); 
    }
}
