package org.example;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<RentalTransaction> transactions;
    private List<Vehicle> vehicles;

    public RentalAgency() {
        this.transactions = new ArrayList<>();
        this.vehicles = new ArrayList<>();
    }

    // Include a vehicle to the agency's fleet
    public void includeVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle included: " + vehicle.getModel());
    }

    // Display all transactions
    public void displayTransactions() {
        System.out.println("Rental transactions:");
        for (RentalTransaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    // Display all vehicles
    public void displayVehicles() {
        System.out.println("Operational Vehicles:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    // Rent a vehicle to a customer
    public void rentVehicle(String vehicleId, Customer customer, int days) {
        Vehicle vehicle = findVehicleAssignedId(vehicleId);

        if (vehicle == null) {
            System.out.println("Vehicle assigned ID " + vehicleId + " not found.");
            return;
        }

        if (!vehicle.isAvailableForRental()) {
            System.out.println("Vehicle " + vehicle.getModel() + " is unavailable for rental.");
            return;
        }

        RentalTransaction transaction = new RentalTransaction(
                "T" + (transactions.size() + 1), customer, vehicle);
        transactions.add(transaction);

        vehicle.rent(customer, days);
        System.out.println("Transaction generated: " + transaction.getTransactionId());
    }

    // Return a rented vehicle
    public void returnRentedVehicle(String transactionId) {
        RentalTransaction transaction = findTransactionById(transactionId);

        if (transaction == null) {
            System.out.println("Transaction assigned ID " + transactionId + " not found.");
            return;
        }

        if (transaction.getHasCompleted()) {
            System.out.println("Transaction " + transactionId + " is already completed.");
            return;
        }

        transaction.setIsCompleted();
        System.out.println("Vehicle returned for transaction: " + transactionId);
    }

    // Helper method to find a vehicle Assigned ID
    public Vehicle findVehicleAssignedId(String vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }

    // Helper method to find a transaction by ID
    public RentalTransaction findTransactionById(String transactionId) {
        for (RentalTransaction transaction : transactions) {
            if (transaction.getTransactionId().equals(transactionId)) {
                return transaction;
            }
        }
        return null;
    }

    public int getVehicles() {
        return vehicles.size();
    }
}
