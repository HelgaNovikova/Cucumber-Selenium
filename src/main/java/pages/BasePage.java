package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.SharedDriver;

import java.util.List;

public class BasePage {

    private static final WebDriver webDriver = SharedDriver.getWebDriver();

    public void navigateToMainPage(String url) {
        webDriver.get(url);
    }

    protected boolean isElementExistInsideElement(WebElement element, String xpath) {
        try {
            element.findElement(By.xpath(xpath));
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    protected WebElement findElementByXpath(String xpath) {
        return webDriver.findElement(By.xpath(xpath));
    }

    protected WebElement findElementByXpathInsideElement(WebElement element, String xpath) {
        return element.findElement(By.xpath(xpath));
    }

    protected List<WebElement> findElementsByXpath(String xpath) {
        return webDriver.findElements(By.xpath(xpath));
    }

    protected void switchToFrame(String xpath) {
        webDriver.switchTo().frame(findElementByXpath(xpath));
    }

    protected void clickElementByXpath(String xpath) {
        findElementByXpath(xpath).click();
    }

    protected String getTextFromElementByXpath(String xpath) {
        return findElementByXpath(xpath).getText();
    }

    protected boolean isElementByXpathDisplayed(String xpath) {
        return findElementByXpath(xpath).isDisplayed();
    }

    protected String getTextFromElementByXpathInsideElement(WebElement element, String xpath) {
        return findElementByXpathInsideElement(element, xpath).getText();
    }

    protected String getTextFromNodeElementByChildXpath(String xpath) {
        WebElement element = webDriver.findElement(By.xpath(xpath));
        String text = element.getText();
        for (WebElement child : element.findElements(By.xpath("./*"))) {
            text = text.replaceFirst(child.getText(), "");
        }
        return text;
    }
}
