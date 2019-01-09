//an example of nested classes - where a c;ass os defined with amother class definition
//linked list - outer class
//Node - inner class
//Node is considered a member of the Linkedlist class


// Programmer: Cameron Dufault
// Date: April 4 2017
// File: Linkedlist.java
// Description: This program creates a linked list blueprint with a number of methods utiliizing it 

public class Linkedlist
{
    //only one characteristic/field for the linked list
    private Node headNode; //by keeping track of head node the enture list will be at our disposal

    public Linkedlist (String data)
    {
	//CANNOT write this.headNode = data;
	//because headNode is a node object and data is string objrct and cannot assign different types
	//we need to assing headNOde with a Node object
	//we instantiate s node object by calling on te node constructor and passing the data
	this.headNode = new Node (data);
    }


    //Accessor and mutators

    public Node getHeadNode ()
    {
	return this.headNode;
    }


    public void setHeadNode (Node headNode)
    {
	this.headNode = headNode;
    }


    //Behavioural methods

    //to add a new node to the end of the list
    public void addNodeOnEnd (String data)
    {
	//start traversing from beginning of list
	Node currentNode = this.headNode;
	while (currentNode.getNextNode () != null)
	{
	    //advance to the next node
	    currentNode = currentNode.getNextNode ();
	}
	//one out of loop, currentNode is the tail node
	//add the next node here
	currentNode.setNextNode (new Node (data));
	//the newly created node becomes the new tail!

    } //addNodeOnEnd


    //to remove the head node at the beginning of the list
    public void removeHeadNode ()
    {
	//this method determines if the linked list has only one item
	if (this.headNode.getNextNode () != null)  //if there is more than one item
	{
	    this.headNode = this.headNode.nextNode; //the head node is now the next node in the sequence
	}
    } //removeHeadNode method


    //this method adds a new node at the front of the linked list
    public void addNodeAtFront (String data)
    {
	Node newNode = new Node (data); //creating new node to hold data
	newNode.setNextNode (headNode); //the new node points to the head
	setHeadNode (newNode); //the head is set to newNode

    } //addNodeAtFront method


    //this method removes the tail of the linked list
    public void removeTail ()
    {
	Node currentNode = this.headNode; //this node will be used to traverse the linked list
	Node nextNode = this.headNode; //this node is used in conjunction with currentNode to traverse the linked list
	//this loop travels through the linked list until the end is reached
	while (nextNode.getNextNode () != null) //while nextNode is not the tail
	{
	    nextNode = nextNode.getNextNode (); //nextNode moves to the node after
	    if (nextNode.getNextNode () != null) //if nextNode is still not the tail
	    {
		currentNode = nextNode; //currentNode is set to nextNode
	    } //end if

	} //end while

	currentNode.setNextNode (null); // currentNode is set as tail
    } //removeTail method


    //this method counts the number of nodes in the linked list
    public int nodeCount ()
    {
	int count = 1; //intializing count to 1
	Node currentNode = this.headNode; //this node will be used to traverse the linked list
	//repeatedly incrememting the count and moving through the linked list until the tail is reached
	while (currentNode.getNextNode () != null) //while currentNode is not the tail
	{
	    count = count + 1;
	    currentNode = currentNode.getNextNode (); //currentNode moves to the next node
	} //end while

	return count;
    } //nodeCount method


    //this method finds which node a specifiec string is at and return the node number
    public int nodeAt (String dataCheck)
    {
	int nodeNum = 1; //this hold the place in the linked list the node being checked is at
	Node currentNode = this.headNode; //this node will be used to traverse the linked list
	//repeatedly checking if the last node has been reached or the node matches the data being checked for
	while ((currentNode.getNextNode () != null) && (currentNode.getData () != dataCheck))
	{
	    currentNode = currentNode.getNextNode (); //currentNode moves to the next node
	    nodeNum = nodeNum + 1;
	} //end while

	if (currentNode.getData () == dataCheck) //if the currentNode has the matching data
	{
	    return nodeNum;
	}
	else //if the name is not present in the linked list
	{
	    nodeNum = -1; //indicates name not presend
	    return nodeNum;
	} //end if
    } //nodeAt method


    //this method adds a new node in a specified part of the linked list
    public void addNodeAt (String data, int nodeLocation)
    {
	Node newNode = new Node (data); //this Node is created to be placed into the linked list with its data
	int count = 1; //holds the place in the linked list
	Node currentNode = this.headNode; //this node will be used to traverse the linked list
	Node prevNode = this.headNode; //this node will be used to traverse the linked list

	//while the required location has not yet been reached
	while (count != nodeLocation)
	{
	    prevNode = currentNode; //prevNode and currentNode are made equal
	    currentNode = currentNode.getNextNode (); //currentNode moves to the nextNode
	    count = count + 1;
	}

	if (count == nodeLocation) //if the required location has been reached
	{
	    newNode.setNextNode (currentNode); //new node points to currentNode
	    if (currentNode == this.headNode) //if currentNode is headNode
	    {
		this.headNode = newNode; //the headNode is now newNode
	    }
	    else
	    {
		prevNode.setNextNode (newNode); //prevNode points to the new node
	    }
	}//end if

    } //addNodeAt method


    //this method removes all the node carrying a specific piece of data
    public void removeNode (String data)
    {
	Node currentNode = this.headNode;  //this node will be used to traverse the linked list
	Node nextNode = this.headNode; //this node will be used to traverse the linked list

	if (this.headNode.getData () == data) //if the headNode contains the data being looked for
	{
	    currentNode = currentNode.getNextNode (); //currentNode moves to the next node
	    this.headNode = currentNode;//the headNode is not the currentNode
	}//end if

	//while the tail has not been reached
	while (currentNode.getNextNode () != null)
	{
	    nextNode = currentNode; //traversing nodes set equal
	    currentNode = currentNode.getNextNode (); //currentnNode moves to nextNode
	    if (currentNode.getData () == data)  //if currentNode has reached a node needed to be removed
	    {
		nextNode.setNextNode (currentNode.getNextNode ()); //nextNode now points to the node past currentNode
	    }//end if
	}//end while

    } //removeNode method





    //To set up the toString which will display the linked list we must calll on
    // the toString which displays a single node in node class
    public String toString ()
    {
	//Start at headNode and repeatedky traverse through the list outputting each node until the tail
	//currentNode marks the movement through the list -  it starts at the head
	Node currentNode = this.headNode;

	String linkString = ""; //String built with nodes
	do
	{
	    //add the current node to the output string
	    //to output the single node call on the Node toString
	    linkString = linkString + currentNode.toString () + "\n";
	    currentNode = currentNode.getNextNode ();


	}
	while (currentNode != null);

	return linkString;
    }


    private class Node
    {
	//Fields
	private String data;  //data stored in the node
	private Node nextNode; //pointer

	//Contructors
	//First constructor will creare a node holding the data and pointing to null (likr the tail)
	//
	public Node (String data)
	{
	    this.data = data;
	    this.nextNode = null;
	}

	//second contstructor will create node holding data plus the poointer to the next node
	public Node (String data, Node nextNode)
	{
	    this.data = data;
	    this.nextNode = nextNode;
	}

	//Accessor and mutators
	public String getData ()
	{
	    return this.data;
	}

	public Node getNextNode ()
	{
	    return this.nextNode;
	}

	public void setData (String data)
	{
	    this.data = data;
	}

	public void setNextNode (Node nextNode)
	{
	    this.nextNode = nextNode;
	}

	public String toString ()
	{
	    String string2;
	    String string1 = "{" + this.data + "} -> ";
	    //check if displaying tail node
	    if (this.nextNode == null)
	    {
		string2 = "NULL";
	    }
	    else
	    {
		//retrieving the data portion of the next node
		string2 = this.nextNode.getData ();
	    }

	    return string1 + string2;

	}



    } //node class
} //loinked list classx


