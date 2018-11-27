package script;

import java.io.*;
import java.util.ArrayList;

import javax.script.*;

import engine.*;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

public class personScript {

	public static void runScript() {
		
//have to include try block to catch errors, wont work without
	    try {
//assign engine manager to nashorn to be able to evaluate the javascript
			ScriptEngineManager engineManager = new ScriptEngineManager();
	        ScriptEngine engine = engineManager.getEngineByName("nashorn");

//room.js is my javascript file to read from, assigned to engine        
	        engine.eval(new FileReader("person.js"));
	        
	    }catch(Exception e) {
			e.printStackTrace();
		}

	  
	}
	   
//function that gets person object from javascript and converts to person java object
	public static void person(ScriptObjectMirror person) {
		String name = "", description = "";
		int health,score;
		ArrayList<Item> inventory = new ArrayList<Item>();
		
		String person_essential = person.callMember("getPerson").toString();
		person_essential = person_essential.replace("[", "");
		person_essential = person_essential.replace("]", "");
		person_essential = person_essential.replace(" ", "");
		String [] myPerson = person_essential.split(",");
		name = myPerson[0];
		health = Integer.valueOf(myPerson[1]);
		score = Integer.valueOf(myPerson[2]);
		
//		System.out.println(name);
//		System.out.println(health);
//		System.out.println(score);
		
		engine.Character person1 = new engine.Character(name,description,health,inventory);
		engine.Main.newPerson.add(person1);
		person1.score += score;
		
	
		
	}


}
	
