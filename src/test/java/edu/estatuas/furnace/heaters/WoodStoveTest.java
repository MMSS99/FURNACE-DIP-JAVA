package edu.estatuas.furnace.heaters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WoodStoveTest {

    WoodStove zeroedStove;
    WoodStove finiteStove;

    @BeforeEach
    void setUp() {
        zeroedStove = new WoodStove();
        finiteStove = new WoodStove(10);
    }

    @Test
    void testHeaterNoLimit(){
        double currentTemp = 11d;
        assertEquals(zeroedStove.heatUp(currentTemp), currentTemp);

        for (int i = 0; i < 5; i++) {
            zeroedStove.chopLogs();
        }

        assertTrue(zeroedStove.heatUp(currentTemp) > currentTemp);

        finiteStove.chopLogs();
        assertTrue(finiteStove.heatUp(currentTemp) > currentTemp);

        currentTemp = 1500d;
        WoodStove infiniteStove = new WoodStove(999999);
        assertTrue(infiniteStove.heatUp(currentTemp) >= 1538d);
        assertTrue(infiniteStove.heatUp(currentTemp) <= 1558d);
    }

    @Test
    void testHeaterLimit(){
        double currentTemp = 4d;
        double desiredTemp = 18d;

        assertTrue(finiteStove.heatUp(currentTemp, desiredTemp) > desiredTemp);

    }

}