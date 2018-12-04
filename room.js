/* no touch!!!!!!!!!! -------------------------------------------------------------------------------------- */
var myjavaclass = Java.type('script.roomScript');

function room(name,description,detail,north,northeast,
	      east,southeast,south,southwest,west,northwest,
	      up,down,item_name,item_description,item_type,item_unlocks,item_uses){
	
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
	this.item_type = item_type;
	this.item_unlocks = item_unlocks;	
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
	return myConnection;
	}
	
	this.getItems = function(){
	var ArrayList = Java.type('java.util.ArrayList');
	var myItem = new ArrayList();
	myItem.add(this.item_name);
	myItem.add(this.item_description);
	myItem.add(this.item_type);
	myItem.add(this.item_unlocks);
	myItem.add(this.item_uses);
	return myItem;
	}
}
	
/* nope ------------------------------------------------------------------------------------------------------------*/



/* can change or alter after this line, just keep same format to not have errors -------------------------------------------*/
/* parameters 1.name, 2.desscription, 3.detail, 4-11.cardinal directions in clock-wise order, 12-13.up and down, 14.item name,
	       15.item decription, 16.item type, 17.item unlocks, 18.item uses  ----------------------------------------------------------------------------*/

 
var room1 = new room("newroomBitches", " a damn fine room", "damn this is nice", "kitchen", "entrance", "null", "null", "null", "null", "null", "null", "null", "null", "key", "a green key", "key", "closet", "1");
myjavaclass.makeRoom(room1);

var room2 = new room("newroomBitches2", " a damn fine room2", "damn this is nice2", "courtyard", "null", "null", "bathroom", "null", "null", "null", "null", "null", "null", "key", "a red key", "key", "gold lock", "2");
myjavaclass.makeRoom(room2);


