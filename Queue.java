// Programmer: Cameron Dufault
// Date: April 10 2017
// File: Queue.java
// Description: This program creates athe blueprint for a Queue object strcuture with various methods to utilize it

public class Queue
{
    private Node front; //the node at the front of the queue
    private Node rear; //the node at the rear of the queue

    //contructor to creste empty qeue
    public Queue ()
    {
	//there are no rear or front nodes
	this.front = null;
	this.rear = null;
    } //queue constructor

    // behavioural methods
    
    //adding a new node to the rear of the queue
    public void enqueue (String data)
    {
	//if the rear is not null, setting the previous rear to point to new rear
	if (this.rear != null)
	{
	    Node newItem = new Node (data);
	    this.rear.setNextNode (newItem);
	    this.rear = newItem;
	}//end if
	else //if the rear is null
	{
	    this.rear = new Node (data);
	    this.rear.setNextNode(null);
	}//end else

	if (this.front == null) //if there is no front node set yet
	    this.front = this.rear; //the node added is noth the front and rear
    }//eneueue method


    //removing node from front of queue
    public void dequeue ()
    {
	this.front = this.front.getNextNode (); //front is simply set to node after
    }//deqeueu method

    //checking if queue is empty
    public boolean isEmpty ()
    {
	if (this.front == null) //if there is a front node it isnt, if there isnt it is 
	    return true;
	else
	    return false;
    }//isEmpty method

    //determining how many nodes in the queue
    public int size ()
    {
	int count = 0; //initializing count
	Node currentNode = this.front; //creating node to tracerse queue
	while (currentNode != null) //while the traversing node is not at the end
	{
	    count = count + 1; //incrememnt count
	    currentNode = currentNode.getNextNode (); //move to next node
	} //end while
	return count;
    }//size method

    //checking what the front node of queue is
    public String viewFront ()
    {
	String result; //holds the value of front node
	result = this.front.getData (); //front value is assigned to front string

	return result;
    }//viewfront methd

    //checking what the rear node of queue is
    public String viewRear ()
    {
	String result; //holds the value of rear node
	result = this.rear.getData (); //rear value is assigned to front string
	return result;
    }//viewRear methd

    //used to output queue
    public String toString ()
    {
	String string1 = "";
	Node currentItem = this.front; //node to traverse queue

	while (currentItem != null) //while the traversing ndoe has not reached the end
	{
	    string1 = string1 + currentItem.toString (); //output node and add space 
	    currentItem = currentItem.getNextNode (); //move to next node
	}
	return string1;
    }//toString method






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
	    String string1 = "[" + this.data + "]\n" + "   V\n";
	    //check if displaying tail node
	    if (this.nextNode == null)
	    {
		string2 = "  NULL";
	    }
	    else
	    {
		//retrieving the data portion of the next node
		string2 = " ";
	    }

	    return string1 + string2;

	}


    }//Node class
}//Queue class

