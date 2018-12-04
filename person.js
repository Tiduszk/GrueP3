/*Do not change whats in this block of comments ---------------------------------------------------------------------*/
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
/* -------------------------------------------------------------------------------------------------------------------*/


/* feel free to change or alter this for whatever you would like, after this line ---------------------------------------------------*/
/* just need to keep the same format to not have errors */

var person1 = new person("venom", "100", "0");
myjavaclass.person(person1);

var person2 = new person("spiderman", "65", "1000");
myjavaclass.person(person2);
