package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void testCalculateRentalCost() {
        Vehicle car = new Car("C1", "Nissan", 50.0, false);
        assertEquals(250.0, car.calculateRentalCost(5));
    }

    @Test
    void testAvailability() {
        Vehicle car = new Car("C1", "Altima", 30.0, true);
        assertTrue(car.getIsAvailable());
        car.setIsAvailable(false);
        assertFalse(car.getIsAvailable());
    }
}

