package engine;

public class Key extends Item{
	String[] unlocks;
	
	public Key(String name , String description , int uses , String[] unlocks) {
		this.name = name;
		this.description = description;
		this.uses = uses;
		this.unlocks = unlocks;
	}

}
