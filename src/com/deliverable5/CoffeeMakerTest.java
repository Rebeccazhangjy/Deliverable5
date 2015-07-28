package com.deliverable5;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.*;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class CoffeeMakerTest {

	// the next 9 tests test the doSomething() method

	// make sure moveNorth is called and 2 is returned so the game continues
	@Test
	public void testMoveNorth() {
		// preconditions
		Player p = mock(Player.class);
		House h = mock(House.class);
		CoffeeMaker cm = new CoffeeMaker(p, h);
		// execution step
		int result = cm.doSomething("N");
		// assertions
		verify(h).moveNorth();
		verify(h, never()).moveSouth();
		assertEquals(result, 2);
	}
		
	// Make sure Player can treat "n" the same as "N" and move to the north room and 2 is returned.
	@Test
	public void testMoveNorthIgnoreCase(){
		// preconditions
		Player p = mock (Player.class);
		House h = mock (House.class);
		CoffeeMaker cm = new CoffeeMaker(p, h);
		// execution step
		int result = cm.doSomething("n");
		// assertions
		verify(h).moveNorth();
		assertEquals(result, 2);
		}

	// make sure moveSouth is called and 3 is returned so the game continues
	@Test
	public void testMoveSouth() {
		// preconditions
		Player p = mock(Player.class);
		House h = mock(House.class);
		CoffeeMaker cm = new CoffeeMaker(p, h);
		// execution step
		int result = cm.doSomething("S");
		// assertions
		verify(h).moveSouth();
		verify(h, never()).moveNorth();
		assertEquals(result, 3);
	}

	// make sure look is called and 4 is returned so the game continues
	@Test
	public void testLook() {
		// preconditions
		Player p = mock(Player.class);
		House h = mock(House.class);
		CoffeeMaker cm = new CoffeeMaker(p, h);
		// execution step
		int result = cm.doSomething("L");
		// assertions
		verify(h).look(p, null);
		assertEquals(result, 4);
	}

	// make sure inventory is called and 5 is returned so the game continues
	@Test
	public void testInventory() {
		// preconditions
		Player p = mock(Player.class);
		House h = mock(House.class);
		CoffeeMaker cm = new CoffeeMaker(p, h);
		// execution step
		int result = cm.doSomething("I");
		// assertions
		verify(p).showInventory();
		assertEquals(result, 5);
	}

	// make sure -1 is returned when drinking inadvisably
	@Test
	public void testDoLoseGame() {
		// preconditions
		Player p = mock(Player.class);
		House h = mock(House.class);
		CoffeeMaker cm = new CoffeeMaker(p, h);
		// execution step
		Mockito.when(p.drink()).thenReturn(false);
		int returnVal = cm.doSomething("D");
		// assertions
		assertEquals(returnVal, -1);
	}

	// make sure 1 is returned when drinking wisely
	@Test
	public void testDoWinGame() {
		House mockHouse = Mockito.mock(House.class);
		Player mockPlayer = Mockito.mock(Player.class);
		CoffeeMaker cm = new CoffeeMaker(mockPlayer, mockHouse);
		Mockito.when(mockPlayer.drink()).thenReturn(true);
		int returnVal = cm.doSomething("D");
		assertEquals(returnVal, 1);
	}
	
	// Make sure Player can get the help through the game and 6 is returned.
	@Test
	public void testHelp() {
		Player p = mock (Player.class);
		House h = mock (House.class);
		CoffeeMaker cm = new CoffeeMaker(p, h);

		int result = cm.doSomething("H");
		assertEquals(result,6);
	}
	
	
	// Make sure Player can enter a command not specified by FUN-ITERATION but nothing happened and 0 is returned.
	@Test
	public void testUnknownCommand(){
		Player p = mock (Player.class);
		House h = mock (House.class);
		CoffeeMaker cm = new CoffeeMaker(p, h);

		int result = cm.doSomething("abcdefg");
		assertEquals(result, 0);
	}


}
