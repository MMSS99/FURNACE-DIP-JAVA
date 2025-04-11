package edu.estatuas.furnace.thermometers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MercuryThermoTest {

    MercuryThermo defaultThermo;
    MercuryThermo extendedThermo;

    @BeforeEach
    void setUp() {
        defaultThermo = new MercuryThermo(22d);
        extendedThermo = new MercuryThermo(22d, 60d);

    }

    @Test
    void checkTemp() {
        defaultThermo.readTemp();

        defaultThermo.updateTemp(50);
        defaultThermo.readTemp();

        extendedThermo.readTemp();

        extendedThermo.updateTemp(50);
        extendedThermo.readTemp();

        extendedThermo.updateTemp(61);
        extendedThermo.readTemp();
    }

}