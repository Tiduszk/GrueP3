var fun1 = function(name){
	print('hello ' + name + ', ');
	return "greetings from javascript";
};

var fun2 = function(v1, v2, v3){
	v4 = v1 + v2 + v3;
	return v4;
}

var ArrayList = Java.type('java.util.ArrayList');
var myList = new ArrayList();
myList.add('the door is now locked!');
myList.add('some added detail has popped up');
myList.add('what is that');
myList.add('the catalina winemixer');

for each (var s in myList) print(s);


var myjavaclass = Java.type('script.nashornScript');
var hello = myjavaclass.hello('for demonstration only');
print(hello);


function Person(firstname, lastname){
	this.firstName = firstname;
	this.lastName = lastname;
	this.getFullName = function() {
		return this.firstName + " " + this.lastName;
	}
}

var person1 = new Person("bond", ", james bond");
myjavaclass.person(person1);

function Item(item, use){
	this.item = item;
	this.use = use;
	this.getItemUse = function(){
		return this.item + " " + this.use;
	}
}

var item1 = new Item("key,  ", "with this you can now escape!!");
myjavaclass.item(item1);

