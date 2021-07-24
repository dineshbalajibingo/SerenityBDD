package pageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ContactUsPage extends PageObject {

    @FindBy(xpath="//h1[contains(text(),'CONTACT US')]")
    WebElementFacade conactUsLink;

    @FindBy(xpath="//input[@placeholder='First Name']")
    WebElementFacade firstName;

    @FindBy(xpath="//input[@placeholder='Last Name']")
    WebElementFacade lastName;

    @FindBy(xpath="//input[@placeholder='Email Address']")
    WebElementFacade email;

    @FindBy(xpath="//textarea[@placeholder='Comments']")
    WebElementFacade comments;

    @FindBy(xpath="//input[@type='submit']")
    WebElementFacade submitBtn;

    @FindBy (xpath = "//input[@type='reset']")
    WebElementFacade resetBtn;

    @FindBy(css = "#contact_reply h1")
    WebElementFacade sumitMsg;

    public void clickContactUsLink() {
        conactUsLink.click();
        Set<String> windows =  getDriver().getWindowHandles();
        String childWindow = null;
        for (String it :windows) {
            childWindow = it;
        }
        getDriver().switchTo().window(childWindow);
    }

    public void enterFirstName(String fname) {
        waitForPageToLoad();
        waitForElementToBePresent(firstName);
        firstName.sendKeys(fname);
    }

    public void enterLastName(String lname) {
        lastName.sendKeys(lname);
    }

    public void enterEmail(String emailAddr) {
        email.sendKeys(emailAddr);
    }

    public void enterComments(String commentsText) {
        comments.sendKeys(commentsText);
    }

    public void clickSubmit() {
       submitBtn.click();
    }

    public void clickReset() {
        resetBtn.click();
    }

    public void launch(String url) {
      //  getDriver().manage().deleteAllCookies();
      //  getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        getDriver().get(url);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public String getDisplayedMessage() {
        return sumitMsg.getText();
    }

    public void waitForPageToLoad() {
        new WebDriverWait(getDriver(), 7000).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForElementToBePresent(WebElementFacade element) {
        waitForCondition().withTimeout(Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element));
    }

}
