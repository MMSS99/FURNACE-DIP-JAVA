package edu.estatuas.furnace.rooms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    Room room;

    @Test
    void getInstance() {
        room = Room.getInstance();
        assertNotNull(room);

        assertEquals(room, Room.getInstance());
    }

    @Test
    void temperatureControl() {
        room = Room.getInstance();
        double temp = room.getTemperature();
        room.updateTemperature(999d);

        assertFalse(temp == room.getTemperature());
    }

    @Test
    void coolingOFf(){
        room = Room.getInstance();
        room.updateTemperature(100d);
        room.coolOff();
        assertFalse(room.getTemperature() == 100d);

        room.updateTemperature(88d);
        room.coolOff(20d);

        assertTrue(room.getTemperature() <= 20d);
    }

}