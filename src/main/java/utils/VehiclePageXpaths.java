package utils;

public final class VehiclePageXpaths {
    private VehiclePageXpaths() {}
    public static final String PRICE = "//div[@id='sidebar-detail']//h3";
    public static final String YEAR = "//span[@data-id='Year']/span";
    public static final String TRANSMISSION = "//strong[text()='Transmission']/..";
    public static final String MAKE = "//span[@data-id='Make']/span";
    public static final String ODOMETER = "//strong[text()='Odometer']/..";
    public static final String MODEL = "//span[@data-id='Model']/span";
    public static final String IS_SOLD = "//div[@class='features-options']/p[1]";
}
