package edu.estatuas.furnace.thermometers;

import edu.estatuas.furnace.rooms.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitalThermoTest {

    Room room = Room.getInstance();
    DigitalThermo unlinkedThermo = new DigitalThermo(20d);
    DigitalThermo linkedThermo = new DigitalThermo(room);

    @Test
    void readTemp() {
        unlinkedThermo.readTemp();
        unlinkedThermo.updateTemp(9999d);
        unlinkedThermo.readTemp();

        linkedThermo.readTemp();
        room.updateTemperature(80.0d);
        linkedThermo.readTemp();
    }
}