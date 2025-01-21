package hellocucumber;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
    public void productPageIsOpen() {
        guestSteps.navigateToProductPage();
    }

    // ==============================
    // SCENARIO 1: Guest adds a comment
    // ==============================

    @Given("a guest user is on the product page")
    public void guestOnProductPage() {
        guestSteps.navigateToProductPage();
    }

    @When("the guest submits a comment")
    public void guestSubmitsComment() {
        guestSteps.submitComment("This is a test comment.");
    }

    @Then("the comment should be submitted successfully")
    public void commentSubmittedSuccessfully() {
        assertTrue(guestSteps.isCommentSubmittedAndConfirm(), "Error: The comment confirmation message was not displayed.");
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
        assertFalse(guestSteps.isGuestCommentingDisabled(), "Error: Guest comment functionality is not disabled!");
        guestSteps.closeBrowser(); // ✅ Close browser after last step
    }
}
