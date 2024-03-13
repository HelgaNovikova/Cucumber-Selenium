package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@AllArgsConstructor
@Data
public class Vehicle {
    private final int year;
    private final String make;
    private final String transmission;
    private final double price;
    private final double odometer;
    private String model;
    private final boolean isSold;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return year == vehicle.year && Double.compare(vehicle.price, price) == 0 && Double.compare(vehicle.odometer, odometer) == 0 && Objects.equals(make, vehicle.make) && Objects.equals(transmission, vehicle.transmission) && Objects.equals(model, vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, make, transmission, price, odometer, model);
    }
}
