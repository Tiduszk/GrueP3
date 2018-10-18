//Made by Zachary Clark

package engine;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import parserXML.*;
import script.*;

public class Main {

	public static void main(String[] args) {
		Room[] world;
		String unknown = "Your command cannot be understood";
		boolean quit = false;
		int current_room = 0;
		boolean complete = false;
		boolean repeat = true;
		String room_name = new String();
		String s = new String();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the name of the xml file: ");
		s = in.nextLine();
		
		//0=North,1=NorthEast,2=East,3=SouthEast,4=South,5=SouthWest,6=West,7=NorthWest,8=Up,9=Down
		world = readxml.create_world(s);
		world[0].discovered = true;
		world[0].locked = false;
		
		s = new String();
		
		//Main game loop
		while(!quit) {
			
			//Displays the description of the room when you enter it
			if(repeat) {
				System.out.println(world[current_room].description);
			}
			
			//Reset flags
			repeat = true;
			complete = false;
			
			//Read input from user
			if(in.hasNextLine()) {
				s = in.nextLine();
			}
				
			//Jump directly to a room if the user types the name of a room
			for(int i = 0; i < Array.getLength(world); i++) {
				if(!world[i].locked && world[i].name.equalsIgnoreCase(s) && (world[i].discovered || Arrays.asList(world[current_room].connections).contains(s.toLowerCase()))) {
					current_room = i;
					world[current_room].discovered = true;
					complete = true;
				}
			}
			
			//Determines what action to take based on the user's input
			if(!complete) {
				switch(s.toLowerCase()) {
				case "observe":
				case "o":
					System.out.println(world[current_room].detail);
					repeat = false;
					break;
					
				case "north":
				case "n":
					room_name = world[current_room].connectedTo(0);
					current_room = get_position(world , room_name , current_room);
					world[current_room].discovered = true;
					break;
					
				case "northeast":
				case "north east":
				case "ne":
				case "n e":
					room_name = world[current_room].connectedTo(1);
					current_room = get_position(world , room_name , current_room);
					world[current_room].discovered = true;
					break;
					
				case "east":
				case "e":
					room_name = world[current_room].connectedTo(2);
					current_room = get_position(world , room_name , current_room);
					world[current_room].discovered = true;
					break;
					
				case "southeast":
				case "south east":
				case "se":
				case "s e":
					room_name = world[current_room].connectedTo(3);
					current_room = get_position(world , room_name , current_room);
					world[current_room].discovered = true;
					break;
					
				case "south":
				case "s":
					room_name = world[current_room].connectedTo(4);
					current_room = get_position(world , room_name , current_room);
					world[current_room].discovered = true;
					break;
					
				case "southwest":
				case "south west":
				case "sw":
				case "s w":
					room_name = world[current_room].connectedTo(5);
					current_room = get_position(world , room_name , current_room);
					world[current_room].discovered = true;
					break;
					
				case "west":
				case "w":
					room_name = world[current_room].connectedTo(6);
					current_room = get_position(world , room_name , current_room);
					world[current_room].discovered = true;
					break;
					
				case "northwest":
				case "north west":
				case "nw":
				case "n w":
					room_name = world[current_room].connectedTo(7);
					current_room = get_position(world , room_name , current_room);
					world[current_room].discovered = true;
					break;
					
				case "up":
				case "u":
					room_name = world[current_room].connectedTo(8);
					current_room = get_position(world , room_name , current_room);
					world[current_room].discovered = true;
					break;
					
				case "down":
				case "d":
					room_name = world[current_room].connectedTo(9);
					current_room = get_position(world , room_name , current_room);
					world[current_room].discovered = true;
					break;
					
				case "quit":
				case "q":
					System.out.println("Are you sure you want to quit? (y/n)");
					s = in.nextLine();
					s.toLowerCase();
					
					if(s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("y")) {
						quit = true;
					}
					break;
					
				case "help":
				case "h":
					System.out.println("Enter a direction, such as North or Southwest, to go in that direction.\n"
							+ "You can also enter the name of a room to go directly to that room.\n"
							+ "Enter \"Quit\" to quit and \"Help\" for help.\n");
					
					repeat = false;
					break;
				
				case "where":
				case "wh":
					for(int i = 0; i < 10; i++) {
						if(!world[current_room].connections[i].equals("null")) {
							switch(i) {
							case 0:
								System.out.println("North: " + world[current_room].connections[i]);
								break;
								
							case 1:
								System.out.println("Northeast: " + world[current_room].connections[i]);
								break;
								
							case 2:
								System.out.println("East: " + world[current_room].connections[i]);
								break;
								
							case 3:
								System.out.println("Southeast: " + world[current_room].connections[i]);
								break;
								
							case 4:
								System.out.println("South: " + world[current_room].connections[i]);
								break;
								
							case 5:
								System.out.println("Southwest: " + world[current_room].connections[i]);
								break;
								
							case 6:
								System.out.println("West: " + world[current_room].connections[i]);
								break;
								
							case 7:
								System.out.println("Northwest: " + world[current_room].connections[i]);
								break;
								
							case 8:
								System.out.println("Up: " + world[current_room].connections[i]);
								break;
								
							case 9:
								System.out.println("Down: " + world[current_room].connections[i]);
								break;
								
							default:
								break;
							}
						}
						
						repeat = false;
					}
					break;
					
				case "script":
				case "sc":
					nashornScript.runScript();
					repeat = false;
					break;
					
				default:
					System.out.println(unknown);
					repeat = false;
					break;
				}
				
			}
			
		}
		
		in.close();

	}
	
	//Returns the position in the world array of the selected room
	static int get_position(Room[] world , String name , int current_position) {
		int current_room = current_position;
		
		for(int i = 0; i < Array.getLength(world); i++) {
			if(world[i].name.equalsIgnoreCase(name)) {
				current_room = i;
			}
		}
		
		return(current_room);
	}

}
