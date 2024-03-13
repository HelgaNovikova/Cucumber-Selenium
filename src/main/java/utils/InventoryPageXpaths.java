package utils;

public final class InventoryPageXpaths {
    private InventoryPageXpaths() {}

    public static final String YEAR_FILTER = "//span[text()='Year ']";
    public static final String YEAR_OPTIONS = "//div[@id='year-refinement-list']//input[@class='ais-RefinementList-checkbox']";
    public static final String MAKE_OPTIONS = "//div[@id='make-refinement-list']//input[@class='ais-RefinementList-checkbox']";
    public static final String TRANSMISSION_FILTER = "//span[contains(text(),'Transmission')]";
    public static final String TRANSMISSION_OPTIONS = "//div[@id='transmission-refinement-list']//input[@class='ais-RefinementList-checkbox']";
    public static final String VEHICLES = "//li[@class='ais-InfiniteHits-item']";
    public static final String SORT_BY = "//select[@class='ais-SortBy-select']";
    public static final String PRICE = ".//div[@class='price-block our-price real-price']//span[@class='price price_value']";
    public static final String SPECIAL_PRICE = ".//div[@class='price-block our-price real-price']//span[@class='price special_price_value']";
    public static final String YEAR_OPTION_SET = "//span[text()='%s']";
    public static final String VEHICLE_TITLE = ".//a[@class='title_value page_url_value']";
    public static final String VEHICLE_TRANSMISSION = ".//span[@class='detail-content transmission_value']";
    public static final String VEHICLE_IS_COLD = ".//div[@class='sold']";
    public static final String MAKE_FILTER = "//span[text()='Make']";
    public static final String VEHICLE_ODOMETER = ".//span[@class='detail-content odometer_value']";
    public static final String TRANSMISSION_OPTION = "//span[text()='%s']";
    public static final String MAKER_OPTION = "//span[text()='%s']";
    public static final String SORT_BY_SMTH = "//option[text()='%s']";
    public static final String VIEW_DETAILS = ".//a[text()='View Details']";
}
