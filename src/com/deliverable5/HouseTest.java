package com.deliverable5;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class HouseTest {

	// This will check getCurrentRoomInfo()
	@Test
	public void testGetDescription() {
		Room r = mock(Room.class);
		when(r.getDescription()).thenReturn("TEST"); // stub of relevant method
		Room[] rooms = new Room[1];
		rooms[0] = r;
		House h = new House(rooms); // real house with fake rooms
		String result = h.getCurrentRoomInfo();
		assertEquals(result, "TEST");
	}
	
	// This test tests generateRooms(), ensuring we get a room array of the right length
	@Test
	public void testGenerateRooms() {
		Room r = mock(Room.class);
		Room[] rooms = new Room[1];
		rooms[0] = r;
		House h = new House(rooms); // real house with fake rooms
		Room[] result = h.generateRooms(3); // should return an array of 3 rooms
		assertEquals(3, result.length);
	}


}
