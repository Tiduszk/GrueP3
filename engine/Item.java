//Made by Zachary Clark

package engine;

import java.util.ArrayList;

public class Item extends Interactable{
	int uses;
	String type;
	ArrayList<String> item_unlocks = new ArrayList<String>();

	public Item() {}
	
	public Item(String name , String description, String type, ArrayList<String> item_unlocks, int uses) {
		this.name = name;
		this.description = description;
		this.type = type;
		this.item_unlocks = item_unlocks;
		this.uses = uses;
	}
	
}
