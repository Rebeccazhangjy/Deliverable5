package com.deliverable5;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {

	
	// The next 2 tests test hasCoffee()
	
	// hasCoffee() should return false when there's no coffee in the room
	@Test
	public void testHasNoCoffee() {
		Room room = new Room(false, false, false, true, true);
		assertFalse(room.hasCoffee());
	}
	
	// hasCoffee() should return true when there's coffee in the room
	@Test
	public void testHasCoffee() {
		Room room = new Room(true, false, false, true, true);
		assertTrue(room.hasCoffee());
	}
	
	
	
	// The next 2 tests test hasCream()
	
		// hasCream() should return false when there's no cream in the room
		@Test
		public void testHasNoCream() {
			Room room = new Room(false, false, false, true, true);
			assertFalse(room.hasCream());
		}
		
		// hasCream() should return true when there's cream in the room
		@Test
		public void testHasCream() {
			Room room = new Room(false, true, false, true, true);
			assertTrue(room.hasCream());
		}

		
	
	// The next 2 tests test hasSugar()
	
	// hasSugar() should return false when there's no sugar in the room
	@Test
	public void testHasNoSugar() {
		Room room = new Room(false, false, false, true, true);
		assertFalse(room.hasSugar());
	}
	
	// hasSugar() should return true when there's sugar in the room
	@Test
	public void testHasSugar() {
		Room room = new Room(false, false, true, true, true);
		assertTrue(room.hasSugar());
	}

	
	
	
	
	// The next 8 tests test the hasItem() method

	// hasItem() should return false when there's nothing in the room
	@Test
	public void testHasItemNothing() {
		Room room = new Room(false, false, false, true, true);
		assertFalse(room.hasItem());
	}

	// hasItem() should return true when all the three ingredients are in the
	// room
	@Test
	public void testHasItemAll() {
		Room room = new Room(true, true, true, true, true);
		assertTrue(room.hasItem());
	}

	// hasItem() should return true when there's only one item in the room,
	// let's say, Coffee
	@Test
	public void testHasItemCoffee() {
		Room room = new Room(true, false, false, true, true);
		assertTrue(room.hasItem());
	}
	
	// hasItem() should return true when there's only one item in the room,
	// let's say, Cream
	@Test
	public void testHasItemCream() {
		Room room = new Room(false, true, false, true, true);
		assertTrue(room.hasItem());
	}
	
	// hasItem() should return true when there's only one item in the room,
	// let's say, Sugar
	@Test
	public void testHasItemSugar() {
		Room room = new Room(false, false, true, true, true);
		assertTrue(room.hasItem());
	}
	
	// hasItem() should return true when there are two items in the room,
	// let's say, Coffee and Cream
	@Test
	public void testHasItemCoffeeCream() {
		Room room = new Room(true, true, false, true, true);
		assertTrue(room.hasItem());
	}
	
	// hasItem() should return true when there are two items in the room,
	// let's say, Coffee and Sugar
	@Test
	public void testHasItemCoffeeSugar() {
		Room room = new Room(true, false, true, true, true);
		assertTrue(room.hasItem());
	}
	
	// hasItem() should return true when there are two items in the room,
	// let's say, Cream and Sugar
	@Test
	public void testHasItemCreamSugar() {
		Room room = new Room(false, true, true, true, true);
		assertTrue(room.hasItem());
	}

	
	
	// The next 2 tests test northExit()
	
	// northExit() should return true when there exists a north exit
	@Test
	public void testNorthExit() {
		Room room = new Room(false, false, false, true, true);
		assertTrue(room.northExit());
	}
	
	// northExit() should return false when there's no north exit
	@Test
	public void testNoNorthExit() {
		Room room = new Room(false, false, false, false, true);
		assertFalse(room.northExit());
	}

	
	
	// The next 2 tests test southExit()
	
	// southExit() should return true when there exists a south exit
	@Test
	public void testSouthExit() {
		Room room = new Room(false, false, false, true, true);
		assertTrue(room.southExit());
	}
	
	// southExit() should return false when there's no south exit
	@Test
	public void testNoSouthExit() {
		Room room = new Room(false, false, false, true, false);
		assertFalse(room.southExit());
	}

	
	
	// Test getDescription()
	// This check the general description of a room with a door leading South
	@Test
	public void testGetDescriptionSouthExit() {
		Room room = new Room(false, false, false, false, true);
		String st = room.getDescription();
		assertTrue(st.contains("You see a"));
		assertTrue(st.contains("room."));
		assertTrue(st.contains("It has a"));
		assertTrue(st.contains("door leads South."));
	}


}
