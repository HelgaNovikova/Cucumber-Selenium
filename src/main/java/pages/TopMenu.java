package pages;
public class TopMenu extends BasePage {
    private static final String ABOUT_US = "//ul[@id='menu-main-menu']//a[text()='About Us']";
    private static final String CONTACT_US = "//ul[@id='menu-main-menu']//a[text()='Contact us']";
    private static final String INVENTORY = "//ul[@id='menu-main-menu']//a[text()='Inventory']";
    private static TopMenu instance;
    public static TopMenu getTopMenu() {
        if (instance == null) {
            instance = new TopMenu();
        }
        return instance;
    }
    public AboutUsPage clickAboutUs() {
        clickElementByXpath(ABOUT_US);
        return AboutUsPage.getPage();
    }
    public ContactUsPage clickContactUs() {
        clickElementByXpath(CONTACT_US);
        return ContactUsPage.getPage();
    }
    public InventoryPage clickInventory() {
        clickElementByXpath(INVENTORY);
        return InventoryPage.getPage();
    }
}
