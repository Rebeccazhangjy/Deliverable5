package com.deliverable5;
public class House {

	private int _numRooms = 6;
	
	private Room[] _rooms = new Room[_numRooms];
	
	private int _currentRoom = 0;
	
	public House(int numRooms) {
		_numRooms = numRooms;
		_rooms = generateRooms(_numRooms);
	}
	
	public House(Room[] rooms) {
		_numRooms = rooms.length;
		_rooms = rooms;
	}
	
	
/*	 
 * REFACTORED
 * 
 * We have fixed the magical land defect so we don't need the check part.
 * Additionally, for easy use purpose, we added room number for each room.
 * 
 * 
*/	
	public String getCurrentRoomInfo() {
		System.out.println("\nYou are in Room " + (_currentRoom + 1) + "."); 
		return _rooms[_currentRoom].getDescription();
	}
	
	
/*	 
 * REFACTORED
 * 
 * In the next two methods, we added an if statement in order to make sure the player cannot move north
 * or south if there's no exit towards that direction.
 * 
*/	
	
	public void moveNorth() {
		if (_rooms[_currentRoom].northExit()){
			_currentRoom += 1;
		}
		else{
			System.out.println("You cannot move north!");
		}
	}
	
	public void moveSouth() {
		if(_rooms[_currentRoom].southExit()){
			_currentRoom -= 1;
		}
		else{
			System.out.println("You cannot move south!");
		}
	}
	
	
	public void look(Player player, Room room) {
		if (room == null) {
			room = _rooms[_currentRoom];
		}
		if (room.hasItem()) {
			System.out.println("There might be something here...");
			if (room.hasCoffee()) {
				player.getCoffee();
			}
			if (room.hasCream()) {
				player.getCream();
			}
			if (room.hasSugar()) {
				player.getSugar();
			}
		} else {
			System.out.println("You don't see anything out of the ordinary.");
		}
	}
	
	
	/*
	 * We didn't make any changes to the code in this method, just made it more clear to read.
	 */
	
	public Room[] generateRooms(int numRooms) {
				
		Room[] toReturn = new Room[numRooms];
		
		boolean northDoor = true;
		boolean southDoor = true;
		boolean hasCoffee = false;
		boolean hasCream = false;
		boolean hasSugar = false;
		
		for (int j = 0; j < numRooms; j++) {
			
			if (j == 0) { 
				hasCream = true; 
			} else {
				hasCream = false; 
			};
			
			if (j == 2) { 
				hasCoffee = true; 
			} else {
				hasCoffee = false; 
			};
			
			if (j == (numRooms - 1)) { 
				hasSugar = true; 
			} else { 
				hasSugar = false; 
			};
			
			if (j == 0) { 
				southDoor = false; 
			} else { 
				southDoor = true; 
			}
			if (j == (numRooms - 1)) { 
				northDoor = false;
			} else { 
				northDoor = true; 
			}
			
			toReturn[j] = new Room(hasCoffee, hasCream, hasSugar, northDoor, southDoor);
		}
		
		return toReturn;
	}
	
	
}
