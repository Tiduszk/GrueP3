
var myjavaclass = Java.type('script.roomScript');

function room(name,description,detail,north,northeast,
	      east,southeast,south,southwest,west,northwest,
	      up,down,item_name,item_description,item_uses){
	
	this.name = name;
	this.description = description;
	this.detail = detail;
	
	this.north = north;
	this.northeast = northeast;
	this.east = east;
	this.southeast = southeast;
	this.south = south;
	this.southwest = southwest;
	this.west = west;
	this.northwest = northwest;
	this.up = up
	this.down = down;
	
	this.item_name = item_name;
	this.item_description = item_description;
	this.item_uses = item_uses;
	
	this.getRoom = function(){
	var ArrayList = Java.type('java.util.ArrayList');
	var myRoom = new ArrayList();
	myRoom.add(this.name);
	myRoom.add(this.description);
	myRoom.add(this.detail);
	return myRoom;
	}
	
	this.getConnections = function(){
	var ArrayList = Java.type('java.util.ArrayList');
        var myConnection = new ArrayList();
	myConnection.add(this.north);
	myConnection.add(this.northeast);
	myConnection.add(this.east);
	myConnection.add(this.southeast);
	myConnection.add(this.south);
	myConnection.add(this.southwest);
	myConnection.add(this.west);
	myConnection.add(this.northwest);
	myConnection.add(this.up);
	myConnection.add(this.down);
	return myConnection;
	}
	
	this.getItems = function(){
	var ArrayList = Java.type('java.util.ArrayList');
	var myItem = new ArrayList();
	myItem.add(this.item_name);
	myItem.add(this.item_description);
	myItem.add(this.item_uses);
	return myItem;
	}
}
	


var room1 = new room("secret room", "a room filled with weapons and gold", "damn this is what i'm talking about", "null", "null", "null", "null", "null", "null", "bedroom", "null", "null", "null", "key", "a green key", "1");
myjavaclass.makeRoom(room1);

var room2 = new room("library", "a room with book cases", "this is insane", "null", "null", "bedroom", "null", "null", "null", "null", "null",
"null", "null", "key", "a red key", "1");
myjavaclass.makeRoom(room2);

