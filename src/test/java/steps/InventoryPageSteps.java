package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Vehicle;
import pages.InventoryPage;
import pages.TopMenu;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryPageSteps {
    private InventoryPage inventoryPage;
    private int year;
    private String transmission;
    private String maker;

    @When("User chooses value in year filter")
    public void userChoosesValuesInFilter() {
        List<String> years = inventoryPage.getYearFilterOptions();
        year = Integer.parseInt(years.get((int) (Math.random() * (years.size() - 1))));
        inventoryPage.setYearFilterOption(year);
    }

    @Then("Result page contains only cars of the chosen year")
    public void resultPageContainsOnlyCarsAccordingToTheAppliedFilter() {
        List<Vehicle> vehicles = inventoryPage.getVehicles();
        vehicles.forEach(v -> assertEquals(v.getYear(), year));
    }

    @Given("User navigates to Inventory page")
    public void userNavigatesToInventoryPage() {
        TopMenu topMenu = TopMenu.getTopMenu();
        topMenu.navigateToMainPage("https://www.rightwayautosale.com/");
        inventoryPage = topMenu.clickInventory();
    }

    @When("User chooses values in transmission filter")
    public void userChoosesValuesInTransmissionFilter() {
        List<String> transmissions = inventoryPage.getTransmissionFilterOptions();
        transmission = transmissions.get((int) (Math.random() * (transmissions.size() - 1)));
        inventoryPage.setTransmissionFilterOption(transmission);
    }

    @Then("Result page contains only cars of the chosen transmission")
    public void resultPageContainsOnlyCarsOfTheChosenTransmission() {
        List<Vehicle> vehicles = inventoryPage.getVehicles();
        vehicles.forEach(v -> assertEquals(v.getTransmission(), transmission));
    }

    @When("User chooses values in make filter")
    public void userChoosesValuesInMakeFilter() {
        List<String> makers = inventoryPage.getMakersOptions();
        maker = makers.get((int) (Math.random() * (makers.size() - 1)));
        inventoryPage.setMakerFilterOption(maker);
    }

    @Then("Result page contains only cars of the chosen maker")
    public void resultPageContainsOnlyCarsOfTheChosenMaker() {
        List<Vehicle> vehicles = inventoryPage.getVehicles();
        vehicles.forEach(v -> assertEquals(v.getMake(), maker));
    }

    @When("User chooses sort by {string}")
    public void userChoosesSortByOdometer(String sortBy) {
        inventoryPage.setSortBy(sortBy);
    }

    @Then("Result page contains cars sorted by {string}")
    public void resultPageContainsCarsSortedByOdometer(String sortBy) {
        List<Vehicle> vehicles = inventoryPage.getVehicles();
        List<Vehicle> sortedVehicles = new ArrayList<>(vehicles);
        switch (sortBy) {
            case "Odometer (Low to High)" -> sortedVehicles.sort(this::compareByOdometerAsc);
            case "Odometer (High to Low)" -> sortedVehicles.sort(this::compareByOdometerDesc);
            case "Year (Low to High)" -> sortedVehicles.sort(this::compareByYearAsc);
            case "Year (High to Low)" -> sortedVehicles.sort(this::compareByYearDesc);
            case "Price (Low to High)" -> sortedVehicles.sort(this::compareByPriceAsc);
            case "Price (High to Low)" -> sortedVehicles.sort(this::compareByPriceDesc);
            case "Make (A - Z)" -> sortedVehicles.sort(this::compareByMakeAsc);
            case "Make (Z - A)" -> sortedVehicles.sort(this::compareByMakeDesc);
            case "Model (A - Z)" -> sortedVehicles.sort(this::compareByModelAsc);
            case "Model (Z - A)" -> sortedVehicles.sort(this::compareByModelDesc);
        }
        assertEquals(sortedVehicles, vehicles);
    }

    private int compareByModelDesc(Vehicle v1, Vehicle v2) {
        Integer x = compareSoldAndNot(v1, v2);
        if (x != null) return x;
        return v1.getModel().toLowerCase().compareTo(v2.getModel().toLowerCase()) * (-1);
    }

    private int compareByModelAsc(Vehicle v1, Vehicle v2) {
        Integer x = compareSoldAndNot(v1, v2);
        if (x != null) return x;
        return v1.getModel().toLowerCase().compareTo(v2.getModel().toLowerCase());
    }

    private int compareByPriceDesc(Vehicle v1, Vehicle v2) {
        Integer x = compareSoldAndNot(v1, v2);
        if (x != null) return x;
        return Double.compare(v1.getPrice(), v2.getPrice()) * (-1);
    }

    private int compareByPriceAsc(Vehicle v1, Vehicle v2) {
        Integer x = compareSoldAndNot(v1, v2);
        if (x != null) return x;
        return Double.compare(v1.getPrice(), v2.getPrice());
    }


    private int compareByYearAsc(Vehicle v1, Vehicle v2) {
        Integer x = compareSoldAndNot(v1, v2);
        if (x != null) return x;
        return Integer.compare(v1.getYear(), v2.getYear());
    }

    private Integer compareSoldAndNot(Vehicle v1, Vehicle v2) {
        if (v1.isSold() && !v2.isSold()) {
            return 1;
        }
        if (!v1.isSold() && v2.isSold()) {
            return -1;
        }
        return null;
    }

    private int compareByYearDesc(Vehicle v1, Vehicle v2) {
        Integer x = compareSoldAndNot(v1, v2);
        if (x != null) return x;
        return Integer.compare(v1.getYear(), v2.getYear()) * (-1);
    }

    private int compareByOdometerDesc(Vehicle v1, Vehicle v2) {
        Integer x = compareSoldAndNot(v1, v2);
        if (x != null) return x;
        return Double.compare(v1.getOdometer(), v2.getOdometer()) * (-1);
    }

    private int compareByOdometerAsc(Vehicle v1, Vehicle v2) {
        Integer x = compareSoldAndNot(v1, v2);
        if (x != null) return x;
        return Double.compare(v1.getOdometer(), v2.getOdometer());
    }

    private int compareByMakeAsc(Vehicle v1, Vehicle v2) {
        Integer x = compareSoldAndNot(v1, v2);
        if (x != null) return x;
        return v1.getMake().compareTo(v2.getMake());
    }

    private int compareByMakeDesc(Vehicle v1, Vehicle v2) {
        Integer x = compareSoldAndNot(v1, v2);
        if (x != null) return x;
        return v1.getMake().compareTo(v2.getMake()) * (-1);
    }

}

