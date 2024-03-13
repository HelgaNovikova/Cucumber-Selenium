package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Vehicle;
import pages.InventoryPage;
import pages.VehiclePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleDetailsSteps {
    private final InventoryPage inventoryPage = InventoryPage.getPage();
    private VehiclePage vehiclePage;
    private Vehicle vehicle;

    @When("User clicks View Details for any car on the inventory page")
    public void userClicksViewDetailsForAnyCarOnTheInventoryPage() {
        vehicle = inventoryPage.getChosenVehicle();
        vehiclePage = inventoryPage.viewDetailsClick();
    }

    @Then("Vehicle details page contains the same vehicle data")
    public void vehicleDetailsPageContainsTheSameVehicleData() {
        assertEquals(vehiclePage.getVehicleData(), vehicle);
    }
}
