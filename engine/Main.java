package engine;

import java.lang.reflect.Array;
import java.util.Scanner;

import parserXML.*;

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
		
		//0=North,1=NorthEast,2=East,3=SouthEast,4=South,5=SouthWest,6=West,7=NorthWest,8=Up,9=Down
		/*String connections[] = new String[10];
		
		String name = "Kitchen";
		String description = "You have entered the Kitchen";
		String detail = "You can go northeast to the enterance, or east to the bedroom";
		connections[1] = "Enterance";
		connections[2] = "Bedroom";
		
		world[0] = new Room(name , description , detail , connections);
		connections = new String[10];
		
		name = "Enterance";
		description = "You have entered the Enterance";
		detail = "You can go southeast to the bedroom, or southwest to the kitchen";
		connections[3] = "Bedroom";
		connections[5] = "Kitchen";
		
		world[1] = new Room(name , description , detail , connections);
		connections = new String[10];
		
		name = "Bedroom";
		description = "You have entered the Bedroom";
		detail = "You can go west to the enterance, or northwest to the kitchen";
		connections[6] = "Enterance";
		connections[7] = "Kitchen";
		
		world[2] = new Room(name , description , detail , connections);
		connections = new String[10];*/
		
		System.out.println("Enter the name of the xml file: ");
		s = in.nextLine();
		
		world = readxml.create_world(s);
		
		s = new String();
		
		while(!quit) {
			if(repeat) {
				System.out.println(world[current_room].description);
			}
			
			repeat = true;
			complete = false;
			
			if(in.hasNextLine()) {
				s = in.nextLine();
			}
				
			for(int i = 0; i < Array.getLength(world); i++) {
				if(world[i].name.equalsIgnoreCase(s)) {
					current_room = i;
					complete = true;
				}
			}
			
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
					break;
					
				case "northeast":
				case "ne":
					room_name = world[current_room].connectedTo(1);
					current_room = get_position(world , room_name , current_room);
					break;
					
				case "east":
				case "e":
					room_name = world[current_room].connectedTo(2);
					current_room = get_position(world , room_name , current_room);
					break;
					
				case "southeast":
				case "se":
					room_name = world[current_room].connectedTo(3);
					current_room = get_position(world , room_name , current_room);
					break;
					
				case "south":
				case "s":
					room_name = world[current_room].connectedTo(4);
					current_room = get_position(world , room_name , current_room);
					break;
					
				case "southwest":
				case "sw":
					room_name = world[current_room].connectedTo(5);
					current_room = get_position(world , room_name , current_room);
					break;
					
				case "west":
				case "w":
					room_name = world[current_room].connectedTo(6);
					current_room = get_position(world , room_name , current_room);
					break;
					
				case "northwest":
				case "nw":
					room_name = world[current_room].connectedTo(7);
					current_room = get_position(world , room_name , current_room);
					break;
					
				case "up":
				case "u":
					room_name = world[current_room].connectedTo(8);
					current_room = get_position(world , room_name , current_room);
					break;
					
				case "down":
				case "d":
					room_name = world[current_room].connectedTo(9);
					current_room = get_position(world , room_name , current_room);
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
					
				default:
					System.out.println(unknown);
					repeat = false;
					break;
				}
				
			}
			
		}
		
		in.close();

	}
	
	static int get_position(Room[] world , String name , int current_position) {
		int current_room = current_position;
		
		for(int i = 0; i < Array.getLength(world); i++) {
			if(world[i].name.equals(name)) {
				current_room = i;
			}
		}
		
		return(current_room);
	}

}
