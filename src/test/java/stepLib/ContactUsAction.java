package stepLib;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObject.ContactUsPage;
import util.Configuration;

import static org.junit.Assert.assertEquals;

public class ContactUsAction {

    ContactUsPage contactUsPage;
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactUsAction.class);

    @Step
    public void launchURl() {
        contactUsPage.launch(Configuration.get("baseUrl"));
    }

    @Step
    public void clickContactUsLink() {
        contactUsPage.clickContactUsLink();

    }

    @Step
    public void enterFirstName() {
        contactUsPage.enterFirstName(Configuration.get("firstName"));
    }

    @Step
    public void enterLastName() {
        contactUsPage.enterLastName(Configuration.get("lastName"));
    }

    @Step
    public void enterEmail() {
        contactUsPage.enterEmail(Configuration.get("email"));
    }

    @Step
    public void enterComments(String commentsText) {
        contactUsPage.enterComments(commentsText);
    }

    @Step
    public void submitForm() {
        contactUsPage.clickSubmit();
    }

    @Step
    public void verifySubmitMessage(String expectedMessage) {
        assertEquals(expectedMessage, contactUsPage.getDisplayedMessage());
    }

}
