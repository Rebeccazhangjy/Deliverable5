package com.deliverable5;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	// The next 8 tests test hasALlItems() method
	
	// hasAllItems() should return false when there's nothing in the player's
	// inventory
	@Test
	public void testHasNothing() {
		Player player = new Player(false, false, false);
		assertFalse(player.hasAllItems());
	}

	// hasAllItems() should return false when there's only one thing, say, Sugar
	// in the player's inventory
	@Test
	public void testHasItemSugar() {
		Player player = new Player(true, false, false);
		assertFalse(player.hasAllItems());
	}
	
	// hasAllItems() should return false when there's only one thing, say, Cream
	// in the player's inventory
	@Test
	public void testHasItemCream() {
		Player player = new Player(false, true, false);
		assertFalse(player.hasAllItems());
	}
	
	// hasAllItems() should return false when there's only one thing, say, Coffee
	// in the player's inventory
	@Test
	public void testHasItemCoffee() {
		Player player = new Player(false, false, true);
		assertFalse(player.hasAllItems());
	}
	
	// hasAllItems() should return false when there are two items, say Sugar and
	// Cream in the player's inventory
	@Test
	public void testHasItemsSugarCream() {
		Player player = new Player(true, true, false);
		assertFalse(player.hasAllItems());
	}
	
	// hasAllItems() should return false when there are two items, say Sugar and
	// Coffee in the player's inventory
	@Test
	public void testHasItemsSugarCoffee() {
		Player player = new Player(true, false, true);
		assertFalse(player.hasAllItems());
	}
	
	// hasAllItems() should return false when there are two items, say Sugar and
	// Cream in the player's inventory
	@Test
	public void testHasItemsCreamCoffee() {
		Player player = new Player(false, true, true);
		assertFalse(player.hasAllItems());
	}
	
	// hasAllItems() should return true when the player have got all three items
	
	@Test
	public void testHasItems() {
		Player player = new Player(true, true, true);
		assertTrue(player.hasAllItems());
	}
	
	
	
	// The next 8 tests test drink() method

	// drink() should return false when the player has nothing in his/her
	// inventory
	@Test
	public void testDrinkNothing() {
		Player player = new Player(false, false, false);
		assertFalse(player.drink());
	}

	// drink() should return false when the player has only Sugar in his/her
	// inventory
	@Test
	public void testDrinkSugar() {
		Player player = new Player(true, false, false);
		assertFalse(player.drink());
	}
	
	
	// drink() should return false when the player has only Cream in his/her
	// inventory
	@Test
	public void testDrinkCream() {
		Player player = new Player(false, true, false);
		assertFalse(player.drink());
	}
	
	// drink() should return false when the player has only Coffee in his/her
	// inventory
	@Test
	public void testDrinkCoffee() {
		Player player = new Player(false, false, true);
		assertFalse(player.drink());
	}
	
	// drink() should return false when the player has only Sugar and Cream in his/her
	// inventory
	@Test
	public void testDrinkSugarCream() {
		Player player = new Player(true, true, false);
		assertFalse(player.drink());
	}
	
	// drink() should return false when the player has only Sugar and Coffee in his/her
	// inventory
	@Test
	public void testDrinkSugarCoffee() {
		Player player = new Player(true, false, true);
		assertFalse(player.drink());
	}
	
	// drink() should return false when the player has only Cream and Coffee in his/her
	// inventory
	@Test
	public void testDrinkCreamCoffee() {
		Player player = new Player(false, true, true);
		assertFalse(player.drink());
	}
	
	
	// drink() should return true when the player has all three items in his/her
	// inventory
	@Test
	public void testDrink_all() {
		Player player = new Player(true, true, true);
		assertTrue(player.drink());
	}

}
