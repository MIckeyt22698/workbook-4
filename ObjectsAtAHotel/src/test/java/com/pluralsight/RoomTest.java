package com.pluralsight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private Room room;

    @Test
    void checkIn_SetsOccupiedAndDirty() {
        room = new Room(2, 120.0, false, false);
        room.checkIn();
        assertTrue(room.isOccupied(), "Room should be occupied after check-in");
        assertTrue(room.isDirty(), "Room should be dirty after check-in");
    }
    @Test
    public void testCheckIn_FailsIfOccupied() {
        room.checkIn(); // first check in
        room.checkIn(); // occupied should fail
        assertTrue(room.isOccupied(), "Room should still be occupied");
        assertTrue(room.isDirty(), "Room should remain dirty");
    }
    @Test
    public void testCheckIn_FailsIfDirty() {
        room.checkIn();     // now dirty
        room.checkOut();    // now empty and dirty should fail
        assertFalse(room.isOccupied(), "Room should not be re-occupied when dirty");
    }
    @Test
    public void testCheckOut_SetsOccupiedFalse_AndLeavesRoomDirty() {
        room.checkIn();
        room.checkOut();
        assertFalse(room.isOccupied(), "Room should not be occupied after checkout");
        assertTrue(room.isDirty(), "Room should remain dirty after checkout");
    }
    @Test
    public void testCleanRoom_SucceedsWhenNotOccupied() {
        room.checkIn();
        room.checkOut();   // empty and dirty
        room.cleanRoom();  // Should succeed
        assertFalse(room.isDirty(), "Room should be clean after cleaning");
    }
    @Test
    public void testCleanRoom_FailsWhenOccupied() {
        room.checkIn();     //occupied and dirty
        room.cleanRoom();   // dont clean
        assertTrue(room.isDirty(), "Room should still be dirty if cleaning fails");
    }
}
