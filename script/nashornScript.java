package script;

import java.io.*;
import javax.script.*;
import jdk.nashorn.api.scripting.ScriptObjectMirror;


public class nashornScript{

	public static void runScript(){
//have to include try block to catch errors, wont work without
    try {
//assign engine manager to nashorn to be able to evaluate the javascript
		ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("nashorn");

//script.js is my javascript file to read from, assigned to engine        
        engine.eval(new FileReader("script.js"));

//create invocable object to be able to call javascript functions
        Invocable invocable = (Invocable) engine;

//fun1 is in javascript file just passes string prints it
        Object result = invocable.invokeFunction("fun1", "tis merely a flesh wound"); 
        System.out.println(result);

//fun2 in javascript file just takes in values and adds them, prints it
	    Object result2 = invocable.invokeFunction("fun2", 5 , 6 , 7);
	    System.out.println(result2);
	
    }catch(Exception e) {
		e.printStackTrace();
	}
  
	}
   
//function that prints out javacript object person from javascript file	
	public static void person(ScriptObjectMirror person) {
		System.out.println("new person is: " + person.callMember("getFullName"));
	}

//function that prints out javascript object item from javascript file	
	public static void item(ScriptObjectMirror item) {
		System.out.println("new item is: " + item.callMember("getItemUse"));
	}

//takes value name from javascript and prints
    public static String hello(String name){
                System.out.format(name);
                return " greeting from java";
        }
}