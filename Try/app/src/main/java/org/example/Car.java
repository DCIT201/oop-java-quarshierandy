package org.example;

public class Car extends Vehicle implements Rentable {
    private boolean hasRadio;

    public Car(String vehicleId, String model, double baseRentalRate, boolean hasRadio) {
        super(vehicleId, model, baseRentalRate);
        this.hasRadio = hasRadio;
    }

    public boolean isHasRadio() {
        return hasRadio;
    }

    @Override
    public double calculateRentalCost(int days) {
        return super.getBaseRentalRate() * days + (hasRadio ? 100 : 0);
    }

    @Override
    public boolean isAvailableForRental() {
        return super.getIsAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental() && customer.checkAgeEligibility()) {
            super.setIsAvailable(false);
            System.out.println(super.getVehicleId() + " has been rented to " + customer.getName());
        } else{
            System.out.println("Car already rented or Invalid age");
        }
    }

    @Override
    public void returnVehicle() {
        setIsAvailable(true);
    }
}
