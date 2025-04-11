package edu.estatuas.furnace.heaters;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GasHeaterTest {

    GasHeater basicHeater = new GasHeater();
    GasHeater complexHeater = new GasHeater(99d);

    @Test
    void testHeatUpSimple() {
        double currentTemp = 11d;
        assertTrue(basicHeater.heatUp(currentTemp) >= basicHeater.getMaxTemp());
        assertTrue(complexHeater.heatUp(currentTemp) >= complexHeater.getMaxTemp());
    }

    @Test
    void testHeatUpComplex() {
        double currentTemp = 11d;
        double desiredTemp = 40d;
        assertTrue(basicHeater.heatUp(currentTemp, desiredTemp) >= desiredTemp);
        assertTrue(complexHeater.heatUp(currentTemp, desiredTemp) >= desiredTemp);

        double desiredTempImpossible = 1000d;
        assertTrue(basicHeater.heatUp(currentTemp, desiredTempImpossible) == currentTemp);
        assertTrue(complexHeater.heatUp(currentTemp, desiredTempImpossible) == currentTemp);
    }

}