package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import stepLib.ContactUsAction;


public class ContactUsSteps {
    @Steps
    ContactUsAction contactUsAction;

    @Given("user access the webdriveruniversity.com")
    public void user_access_the_webdriveruniversity_com() {
        //contactUsAction.launchURl();
        //System.out.println("Printing 1");
    }

    @When("clicks on the ContactUs Form link")
    public void clicks_on_the_contact_us_form_link() {
       // contactUsAction.clickContactUsLink();
        System.out.println("Printing @Smoke");
    }

    @When("enters a valid firstname")
    public void enters_a_valid_firstname() {
        //contactUsAction.enterFirstName();
        System.out.println("Printing @Smoke");
    }

    @When("enters a valid lastname")
    public void enters_a_valid_lastname() {
       // contactUsAction.enterLastName();
        System.out.println("Printing @Regression");
    }

    @When("enters an email address")
    public void enters_an_email_address() {
       // contactUsAction.enterEmail();
        System.out.println("Printing @Regression");
    }
    @When("^provide additional comments as (.*) in the comments box$")
    public void provide_additional_comments_in_the_comments_box(String commentsText) {
        contactUsAction.enterComments(commentsText);
    }
    @When("submits the form")
    public void submits_the_form() {
        contactUsAction.submitForm();
    }
    @Then("the form should be successfully submitted displaying (.*)$")
    public void the_form_should_be_successfully_submitted(String message) {
        contactUsAction.verifySubmitMessage(message);
    }
}
