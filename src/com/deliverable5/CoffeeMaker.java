package com.deliverable5;

import java.util.Scanner;

/*
 * Coffee Maker Quest 2.0
*/

/*
 * We removed the Game class and put those methods here, because we found that the Game class is not very necessary.
 * Its methods don't use multiple times but only once in the CoffeeMaker class, so we did this.
*/

public class CoffeeMaker {
	
	private Player _player = null;
	private House _house = null;
	
	/*
	 * ADDED
	 * 
	 * We added a new constructor to the CoffeeMaker class.
	 * 
	 */
	public CoffeeMaker(Player p, House h) {
		_player = p;
		_house = h;
	}
	
	/*
	 * REFACTORED
	 * 
	 * We put the entire Game.run() method inside of this method.
	 * 
	 */
	private int runGameLoop(Player p, House h) {
		
		int toReturn = 0;
		
		_player = p;
		_house = h;
		
		Scanner in = new Scanner(System.in);
		String move = null;
		
		boolean gameOver = false;
		boolean win = false;
		
		while (!gameOver) {
			System.out.println(_house.getCurrentRoomInfo());
			System.out.println(" INSTRUCTIONS (N,S,L,I,D) > ");
			move = in.nextLine();
			int status = doSomething(move);
			if (status == 1) {
				gameOver = true;
				win = true;
			} else if (status == -1) {
				gameOver = true;
				win = false;
			}
		}
		
		if (win) {
			System.out.println("You win!");
			toReturn = 0;
		} else {
			System.out.println("You lose!");
			toReturn = 1;
		}
		
		return toReturn;
	}
	
	
	/*
	 * REFACTORED
	 * 
	 * We moved this method from Game class to here. 
	 * We removed the case sensitivity for "n" and "N" and added the "H" command.
	 * We made changes so that every command returns a different int value so that by verifying the toReturn value, 
	 * we can verify which command the player entered.
	 * 
	 */
	
	public int doSomething(String move) {
		int toReturn = 0;
		if (move.equalsIgnoreCase("N")) {          // We made it case-insensitive for "n" and "N". 
			_house.moveNorth();
			toReturn = 2;
		} else if (move.equalsIgnoreCase("S")) {
			_house.moveSouth();
			toReturn = 3;
		} else if (move.equalsIgnoreCase("L")) {
			_house.look(_player, null);
			toReturn = 4;
		} else if (move.equalsIgnoreCase("I")) {
			_player.showInventory();
			toReturn = 5;
		} else if (move.equalsIgnoreCase("D")) {
			boolean finalStatus = _player.drink();
			if (finalStatus) {
				toReturn = 1;
			} else {
				toReturn = -1;
			}
		} else if (move.equalsIgnoreCase("H")) {
			toReturn = 6;
			System.out.println("\nInstructions for Coffee Maker Quest - ");
			System.out.println("You are a brave student trying to study for finals, but you need caffeine.");
			System.out.println("The goal of the game is to collect sugar, coffee, and cream and drink them so that you can study.");
			System.out.println("\nAvailable commands are: ");
			System.out.println(" N - Move North");
			System.out.println(" S - Move South");
			System.out.println(" L - Look for Items");
			System.out.println(" I - Check Inventory");
			System.out.println(" D - Drink");
			System.out.println(" H - Get Some Help");
		} else {
			System.out.println("What?");
		}
		return toReturn;
	}

	
	/*
	 * REMOVED
	 * 
	 * We removed this method and moved the statement to the main method at the beginning of the program
	 * as the instructions for the game.
	 */
	
//	public int runArgs(String arg) {
//		System.out.println("Instructions for Coffee Maker Quest - ");
//		System.out.println("You are a brave student trying to study for finals, but you need caffeine.");
//		System.out.println("The goal of the game is to collect sugar, coffee, and cream so that you can study.");
//		return 0;
//	}
	
	/*
	 * REFACTORED
	 * 
	 * As the parameter for the program is not necessary, we removed the if statement and moved the instructions for 
	 * Coffee Maker Quest to the beginning of the program.
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("Coffee Maker Quest 2.0");
		System.out.println("\nInstructions for Coffee Maker Quest - ");
		System.out.println("You are a brave student trying to study for finals, but you need caffeine.");
		System.out.println("The goal of the game is to collect sugar, coffee, and cream and drink them so that you can study.");
		
		int returnValue = 0;
		
//		if (args.length == 0) {
			Player p = new Player();
			House h = new House(6);
			CoffeeMaker cm = new CoffeeMaker(p, h); // We moved the CoffeeMaker constructor after the Player and the House.
//			Game g = new Game(p, h);              // As we removed the Game class, we also removed the parameter of Game.
			returnValue = cm.runGameLoop(p, h);   // The original statement was returnValue = cm.runGameLoop(p, h, g);	 
//		} else {
//			returnValue = cm.runArgs(args[0]);
//		}
		
		System.out.println("Exiting with error code " + returnValue);
	}

}
