package script;

import java.io.*;

import javax.script.*;


import engine.Room;
import jdk.nashorn.api.scripting.ScriptObjectMirror;


public class roomScript{
	
	public static void runScript() {

//have to include try block to catch errors, wont work without
		try {
	
//assign engine manager to nashorn to be able to evaluate the javascript
		ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("nashorn");

//room.js is my javascript file to read from, assigned to engine        
        engine.eval(new FileReader("room.js"));

//create invocable object to be able to call javascript functions
//        Invocable invocable = (Invocable) engine;
        
    }catch(Exception e) {
		e.printStackTrace();
	}
		
}
   
//function that gets room object from javascript and creates new room object in java	
	public static void makeRoom(ScriptObjectMirror room) {
		
		String room_essential = room.callMember("getRoom").toString();
		String [] tokens = room_essential.split(",");
		String name = tokens[0];
		name = name.replace("[", "");
		String description = tokens[1];
		String detail = tokens[2];
		detail = detail.replace("]", "");
		
		String room_connections = room.callMember("getConnections").toString();
		room_connections = room_connections.replace("[", "");
		room_connections = room_connections.replace("]", "");
		String [] connections = room_connections.split(",");
		
		
		String room_items = room.callMember("getItems").toString();
		room_items = room_items.replace("[", "");
		room_items = room_items.replace("]", "");
		String [] items = room_items.split(",");
		
		Room addRoom = new Room(name , description , detail , connections, items);
		engine.Main.newRoom.add(addRoom);
	
		
	}
	
}