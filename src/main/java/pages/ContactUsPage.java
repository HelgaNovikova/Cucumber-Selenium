package pages;

import static utils.ContactUsPageXpaths.*;

public class ContactUsPage extends BasePage {
    private static ContactUsPage instance;

    public static ContactUsPage getPage() {
        if (instance == null) {
            instance = new ContactUsPage();
        }
        return instance;
    }

    public boolean isPossibleToSendMessage() {
        switchToFrame(IFRAME);
        return isElementByXpathDisplayed(FIRST_NAME_INPUT) &&
                isElementByXpathDisplayed(LAST_NAME_INPUT) &&
                isElementByXpathDisplayed(PHONE_INPUT) &&
                isElementByXpathDisplayed(EMAIL_INPUT) &&
                isElementByXpathDisplayed(MESSAGE_INPUT) &&
                isElementByXpathDisplayed(SUBMIT_BUTTON);
    }
}
