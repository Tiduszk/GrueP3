package engine;

import java.util.ArrayList;

public class person {
	
	String name = "duke nukem";
	int health = 100;
	int score = 0;
	ArrayList<Item> inventory = new ArrayList<Item>();
	
	public person(){}
	
	public person(String name, int health, int score){
		this.name = name;
		this.health = health;
		this.score = score;
		ArrayList<Item> inventory;
	}
	
	String getName(){
		return name;
	}

	int getHealth(){
		return health;
	}

	int getScore(){
		return score;
	}

	ArrayList<Item> getInventory(){
		return inventory;
	}

}
