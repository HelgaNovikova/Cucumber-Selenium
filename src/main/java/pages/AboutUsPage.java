package pages;

public class AboutUsPage extends BasePage {
    private static final String PAGE_TITLE = "//h1[@class='entry-title']";
    private static AboutUsPage instance;

    public static AboutUsPage getPage() {
        if (instance == null) {
            instance = new AboutUsPage();
        }
        return instance;
    }

    public String getPageTitle() {
        return getTextFromElementByXpath(PAGE_TITLE);
    }
}
