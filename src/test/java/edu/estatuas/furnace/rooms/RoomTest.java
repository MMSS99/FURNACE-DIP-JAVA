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
    void emperatureControl() {
        room = Room.getInstance();
        double temp = room.getTemperature();
        room.updateTemperature(999d);

        assertFalse(temp == room.getTemperature());
    }

}