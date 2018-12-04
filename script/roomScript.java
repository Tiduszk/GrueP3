package script;

import java.io.*;
import java.util.ArrayList;

import javax.script.*;


import engine.*;
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
		String room_locked = "0";
		boolean locked = toBool(room_locked);
		
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
		
		//Prototype locked code
//		String room_locked = room.callMember("getLocked").toString();
//		room_locked = room_locked.replace("[", "");
//		room_locked = room_locked.replace("]", "");
//		boolean locked = toBool(room_locked);
		
		String room_items = room.callMember("getItems").toString();
		room_items = room_items.replace("[", "");
		room_items = room_items.replace("]", "");
		room_items = room_items.replaceAll(" ", "");
		String [] items_prototype = room_items.split(",");
		//Prototype inventory code
		ArrayList<String> item_unlocks = new ArrayList<String>();
		
		item_unlocks.add(items_prototype[3]);  
		ArrayList<Item> items = new ArrayList<Item>();
		Item item_1 = new Item(items_prototype[0] , items_prototype[1], items_prototype[2], item_unlocks , Integer.parseInt(items_prototype[4]));
		items.add(item_1);
				
		Room addRoom = new Room(name , description , detail , connections, locked, items);
		engine.Main.newRoom.add(addRoom);
	
		
	}
	
	private static boolean toBool(String room_locked) {
		boolean locked;
		int temp = Integer.parseInt(room_locked);
		if(temp == 0) {
			locked = false;
		}
		else {
			locked = true;
		}
		return(locked);
	}
	
}

