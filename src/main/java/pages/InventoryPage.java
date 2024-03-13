package pages;

import model.Vehicle;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.InventoryPageXpaths.*;

public class InventoryPage extends BasePage {

    private static InventoryPage instance;
    private WebElement chosenVehicle;

    public static InventoryPage getPage() {
        if (instance == null) {
            instance = new InventoryPage();
        }
        return instance;
    }

    public List<String> getYearFilterOptions() {
        clickElementByXpath(YEAR_FILTER);
        return findElementsByXpath(YEAR_OPTIONS).stream().map(e -> e.getAttribute("value")).toList();
    }

    public void setYearFilterOption(int year) {
        clickElementByXpath(String.format(YEAR_OPTION_SET, year));
    }

    public List<Vehicle> getVehicles() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> vehicles = findElementsByXpath(VEHICLES);
        return vehicles.stream().map(this::getVehicleFromElement).toList();
    }

    private Vehicle getVehicleFromElement(WebElement v) {
        String title = getTextFromElementByXpathInsideElement(v, VEHICLE_TITLE).replaceAll("[^-a-zA-Z0-9| ]", "");
        title = title.substring(0, title.indexOf("|")).trim();
        title = title.substring(0, title.lastIndexOf(" ")).trim();
        String[] titleArr = title.split(" ");
        int year = Integer.parseInt(titleArr[0]);
        String make = titleArr[1];
        StringBuilder model = new StringBuilder(titleArr[2]);
        for (int i = 3; i < titleArr.length; i++) {
            model.append(" ").append(titleArr[i]);
        }
        double price = getVehiclePrice(v);
        double odometer = getVehicleOdometer(v);
        String transmission = getTextFromElementByXpathInsideElement(v, VEHICLE_TRANSMISSION);
        boolean isSold = findElementByXpathInsideElement(v, VEHICLE_IS_COLD).isDisplayed();
        return new Vehicle(year, make, transmission, price, odometer, model.toString(), isSold);
    }

    private double getVehiclePrice(WebElement vehicle) {
        String finalPrice;
        if (isElementExistInsideElement(vehicle, PRICE)) {
            finalPrice = getTextFromElementByXpathInsideElement(vehicle, PRICE);
        } else {
            finalPrice = getTextFromElementByXpathInsideElement(vehicle, SPECIAL_PRICE);
        }
        return Double.parseDouble(finalPrice.replaceAll("[$,]", ""));
    }

    private double getVehicleOdometer(WebElement vehicle) {
        return Double.parseDouble(getTextFromElementByXpathInsideElement(vehicle, VEHICLE_ODOMETER).replaceAll("[^0-9]", ""));
    }

    public List<String> getTransmissionFilterOptions() {
        clickElementByXpath(TRANSMISSION_FILTER);
        return findElementsByXpath(TRANSMISSION_OPTIONS).stream().map(e -> e.getAttribute("value")).toList();
    }

    public void setTransmissionFilterOption(String transmission) {
        clickElementByXpath(String.format(TRANSMISSION_OPTION, transmission));
    }

    public List<String> getMakersOptions() {
        clickElementByXpath(MAKE_FILTER);
        return findElementsByXpath(MAKE_OPTIONS).stream().map(e -> e.getAttribute("value")).toList();
    }

    public void setMakerFilterOption(String maker) {
        clickElementByXpath(String.format(MAKER_OPTION, maker));
    }

    public void setSortBy(String sortBy) {
        clickElementByXpath(SORT_BY);
        clickElementByXpath(String.format(SORT_BY_SMTH, sortBy));
    }

    public Vehicle getChosenVehicle() {
        List<WebElement> vehicles = findElementsByXpath(VEHICLES);
        int index = (int) (Math.random() * (vehicles.size() - 1));
        chosenVehicle = vehicles.get(index);
        return getVehicleFromElement(chosenVehicle);
    }

    public VehiclePage viewDetailsClick() {
        findElementByXpathInsideElement(chosenVehicle, VIEW_DETAILS).click();
        return VehiclePage.getPage();
    }
}
