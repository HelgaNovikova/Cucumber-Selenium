package pages;

import model.Vehicle;

import static utils.VehiclePageXpaths.*;

public class VehiclePage extends BasePage {
    private static VehiclePage instance;

    public static VehiclePage getPage() {
        if (instance == null) {
            instance = new VehiclePage();
        }
        return instance;
    }

    public Vehicle getVehicleData() {
        int year = Integer.parseInt(getTextFromElementByXpath(YEAR));
        boolean isSold = getTextFromElementByXpath(IS_SOLD).toLowerCase().contains("sold");
        String model = getTextFromElementByXpath(MODEL).trim();
        String make = getTextFromElementByXpath(MAKE).trim();
        String transmission = getTextFromNodeElementByChildXpath(TRANSMISSION).replaceAll("[^a-zA-Z]", "");
        double odometer = Double.parseDouble(getTextFromElementByXpath(ODOMETER).replaceAll("[^0-9]", ""));
        double price = Double.parseDouble(getTextFromElementByXpath(PRICE).replaceAll("[$,]", ""));
        return new Vehicle(year, make, transmission, price, odometer, model, isSold);
    }

}
