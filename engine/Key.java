package engine;

import java.util.ArrayList;

public class Key extends Item{
	ArrayList<String> unlocks;
	
	public Key(String name , String description , int uses , ArrayList<String> unlocks) {
		this.name = name;
		this.description = description;
		this.uses = uses;
		this.unlocks = unlocks;
	}

}
