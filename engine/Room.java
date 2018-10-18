//Made by Zachary Clark

package engine;

public class Room extends Interactable{
	public String detail;
	public String[] connections = new String[10];
	public boolean locked = false;
	public boolean discovered = false;
	
	//No args constructor -- Don't use!
	public Room() {}
	
	//Usable constructor
	public Room(String name , String description , String detail , String[] connections) {
		this.name = name;
		this.description = description;
		this.detail = detail;
		this.connections = connections;
	}
	
	//Returns a the name of the room connected to the current room in the given direction
	public String connectedTo(int direction) {
		String connected = new String();
		
		//0=North,1=NorthEast,2=East,3=SouthEast,4=South,5=SouthWest,6=West,7=NorthWest,8=Up,9=Down
		switch(direction) {
		case 0: connected = connections[0];
			break;
		case 1: connected = connections[1];
			break;
		case 2: connected = connections[2];
			break;
		case 3: connected = connections[3];
			break;
		case 4: connected = connections[4];
			break;
		case 5: connected = connections[5];
			break;
		case 6: connected = connections[6];
			break;
		case 7: connected = connections[7];
			break;
		case 8: connected = connections[8];
			break;
		case 9: connected = connections[9];
			break;
		default: break;
		}
		
		return(connected);
	}
	
}
