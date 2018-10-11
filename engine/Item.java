//Made by Zachary Clark

package engine;

public class Item extends Interactable{
	int uses;

	public Item() {}
	
	public Item(String name , String description, int uses) {
		this.name = name;
		this.description = description;
		this.uses = uses;
	}
	
}
