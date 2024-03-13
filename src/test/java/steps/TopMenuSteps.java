package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AboutUsPage;
import pages.ContactUsPage;
import pages.TopMenu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TopMenuSteps {
    private final TopMenu topMenu;
    private AboutUsPage aboutUsPage;
    private ContactUsPage contactUsPage;

    public TopMenuSteps() {
        this.topMenu = TopMenu.getTopMenu();
    }

    @Given("User navigates to {string} page")
    public void userNavigatesToHttpsWwwLegionQaComPage(String url) {
        topMenu.navigateToMainPage(url);
    }


    @When("User clicks About Us")
    public void userClicksAboutUs() {
        aboutUsPage = topMenu.clickAboutUs();
    }

    @Then("Page with correct title is opened")
    public void pageWithCorrectTitleIsOpened() {
        assertEquals("About Us", aboutUsPage.getPageTitle());
    }

    @When("User clicks Contact Us")
    public void userClicksContactUs() {
        contactUsPage = topMenu.clickContactUs();
    }

    @Then("It's possible to send a message")
    public void itSPossibleToSendAMessage() {
        assertTrue(contactUsPage.isPossibleToSendMessage());
    }

}

