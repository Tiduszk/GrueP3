var myjavaclass = Java.type('script.personScript');

function person(name, health, score){
	this.name = name;
	this.health = health;
	this.score = score;
	
	this.getPerson = function(){
		var ArrayList = Java.type('java.util.ArrayList');
		var myPerson = new ArrayList();
		myPerson.add(this.name);
		myPerson.add(this.health);
		myPerson.add(this.score);
		return myPerson;
		}
}

var person1 = new person("venom", "100", "0");
myjavaclass.person(person1);

var person2 = new person("Macho Man Randy Savage", "65", "1000");
myjavaclass.person(person2);

var person3 = new person("Dr.Rumack(dont call me shirley)", "100", "10000");
myjavaclass.person(person3);

 
