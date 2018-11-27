package engine;

import java.util.ArrayList;

public class Character extends Interactable {
	public int health;
	public ArrayList<Item> inventory;
	public int score = 0;
	
	//No args constructor -- Don't use!
		public Character() {}
		
		//Usable constructor
		public Character(String name , String description , int health , ArrayList<Item> inventory) {
			this.name = name;
			this.description = description;
			this.health = health;
			this.inventory = inventory;
		}

}
